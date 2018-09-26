package com.ustory.relax_business_component.plugin

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.AssetManager
import android.content.res.Resources
import dalvik.system.DexClassLoader
import java.util.*

/**
 * Created by qiyue on 2018/1/30.
 */

class PluginManager private constructor(context: Context) {

    private val dexOutputPath: String? = null
    private val mNativeLibDir: String? = null
    private val mContext: Context

    val plugins = HashMap<String?, Loader>()

    init {
        mContext = context.applicationContext
        //        mNativeLibDir = mContext.getDir("pluginlib", Context.MODE_PRIVATE).getAbsolutePath();

    }

    fun loadApk(plugin: Plugin) {
        val loader = Loader()

        if (checkNewVersion(plugin)) {

        } else {
            /**
             * 最好开线程
             */
            val versionCode = loader.loadDefaultPlugin(mContext, plugin.fileName!!)
            plugin.version = versionCode
            plugins[plugin.key] = loader
        }

    }

    private fun checkNewVersion(plugin: Plugin): Boolean {

        //联网检查是否有新版本 ，如果有就下载，可以在下载到指定目录，然后调用 loader.loadPlugin
        return false
    }

    fun replaceContextResources(context: Context, mResources: Resources) {
        try {
            val field = context.javaClass.getDeclaredField("mResources")
            field.set(context, mResources)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun getClassLoader(key: String): DexClassLoader? {

        return if (plugins.containsKey(key)) {
            plugins[key]?.dexClassLoader
        } else null
    }

    fun getPluginResources(key: String): Resources? {
        return if (plugins.containsKey(key)) {
            plugins[key]?.resources
        } else null
    }

    fun getAssets(key: String): AssetManager? {
        return if (plugins.containsKey(key)) {
            plugins[key]?.assets
        } else null
    }


    fun getActivityInfo(key: String): ActivityInfo? {
        return if (plugins.containsKey(key)) {
            plugins[key]?.activityInfo
        } else null

    }

    companion object {
        private var sInstance: PluginManager? = null

        fun getInstance(context: Context): PluginManager? {
            if (sInstance == null) {
                synchronized(PluginManager::class.java) {
                    if (sInstance == null) {
                        sInstance = PluginManager(context)
                    }
                }
            }
            return sInstance
        }
    }
}
