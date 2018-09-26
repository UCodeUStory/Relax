package com.ustory.relax_business_component.plugin

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.pm.ActivityInfo
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Build
import android.util.Log
import dalvik.system.DexClassLoader
import java.io.File
import java.io.IOException

/**
 * Created by qiyue on 2018/2/1.
 */

class Loader {

    var dexClassLoader: DexClassLoader? = null
        private set

    var resources: Resources? = null

    private var mContext: Context? = null

    private var packageInfo: PackageInfo? = null

    var activityInfo: ActivityInfo? = null
        private set

    private var mClass: String? = null

    var assets: AssetManager? = null
        private set


    /**
     *
     * @param context
     * @param apkPath
     */
    fun loadPlugin(context: Context, apkPath: String) {
        mContext = context.applicationContext

        val cacheFile = FileUtils.getCacheDir(context.applicationContext)

        val internalPath = cacheFile.absolutePath + File.separator + apkPath

        Log.i("qiyue", "internalPath=$internalPath")
        val desFile = File(internalPath)
        try {
            /**
             * 如果第一次初始化默认插件
             */
            if (!desFile.exists()) {
                desFile.createNewFile()
                FileUtils.copyFiles(context, apkPath, desFile)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        packageInfo = mContext!!.packageManager.getPackageArchiveInfo(internalPath,
                PackageManager.GET_ACTIVITIES or PackageManager.GET_SERVICES)

        if (packageInfo == null) {
            return
        }
        val dexOpt = context.getDir("dexOpt", MODE_PRIVATE)
        dexClassLoader = DexClassLoader(
                internalPath,
                dexOpt.absolutePath, null,
                context.classLoader)
        resources = loadPluginResource(context, internalPath)
        initializeActivityInfo()

    }

    fun loadDefaultPlugin(context: Context, fileName: String): Int {
        mContext = context.applicationContext

        val cacheFile = FileUtils.getCacheDir(context.applicationContext)

        val internalPath = cacheFile.absolutePath + File.separator + fileName

        Log.i("qiyue", "internalPath=$internalPath")
        val desFile = File(internalPath)
        try {
            /**
             * 如果第一次初始化默认插件
             */
            if (!desFile.exists()) {
                desFile.createNewFile()
                FileUtils.copyFiles(context, fileName, desFile)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        packageInfo = mContext!!.packageManager.getPackageArchiveInfo(internalPath,
                PackageManager.GET_ACTIVITIES or PackageManager.GET_SERVICES)

        if (packageInfo == null) {
            return -1
        }
        val dexOpt = context.getDir("dexOpt", MODE_PRIVATE)
        dexClassLoader = DexClassLoader(
                internalPath,
                dexOpt.absolutePath, null,
                context.classLoader)
        resources = loadPluginResource(context, internalPath)
        initializeActivityInfo()
        return packageInfo!!.versionCode

    }


    private fun loadPluginResource(context: Context, apkPath: String): Resources {
        assets = createAssetManager(apkPath)
        return Resources(assets, context.resources.displayMetrics, context.resources.configuration)
    }

    private fun createAssetManager(apkPath: String): AssetManager? {
        try {
            val assetManager = AssetManager::class.java.newInstance()
            AssetManager::class.java.getDeclaredMethod("addAssetPath", String::class.java).invoke(
                    assetManager, apkPath)
            return assetManager
        } catch (th: Throwable) {
            th.printStackTrace()
        }

        return null
    }


    private fun initializeActivityInfo() {

        for (activityInfo in packageInfo!!.activities) {
            Log.i("qiyue", "activity" + activityInfo.toString())
        }

        if (packageInfo!!.activities != null && packageInfo!!.activities.size > 0) {
            if (mClass == null) {
                mClass = packageInfo!!.activities[0].name
            }

            //Finals 修复主题BUG
            val defaultTheme = packageInfo!!.applicationInfo.theme
            for (a in packageInfo!!.activities) {
                if (a.name == mClass) {
                    activityInfo = a
                    // Finals ADD 修复主题没有配置的时候插件异常
                    if (activityInfo!!.theme == 0) {
                        if (defaultTheme != 0) {
                            activityInfo!!.theme = defaultTheme
                        } else {
                            if (Build.VERSION.SDK_INT >= 14) {
                                activityInfo!!.theme = android.R.style.Theme_DeviceDefault
                            } else {
                                activityInfo!!.theme = android.R.style.Theme
                            }
                        }
                    }
                }
            }

        }
    }
}
