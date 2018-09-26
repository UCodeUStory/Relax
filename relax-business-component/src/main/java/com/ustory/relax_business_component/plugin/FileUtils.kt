package com.ustory.relax_business_component.plugin

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.res.AssetManager
import android.content.res.Resources
import android.os.Environment
import android.util.Log
import dalvik.system.DexClassLoader
import java.io.*

/**
 * Created by qiyue on 2018/1/30.
 */

class FileUtils {

    lateinit var resources: Resources


    fun loadApk(context: Context, fileName: String): DexClassLoader {

        val cacheFile = FileUtils.getCacheDir(context.applicationContext)

        val internalPath = cacheFile.absolutePath + File.separator + fileName

        Log.i("qiyue", "internalPath=$internalPath")
        val desFile = File(internalPath)

        try {

            if (!desFile.exists()) {

                desFile.createNewFile()
                FileUtils.copyFiles(context, fileName, desFile)
            }

        } catch (e: IOException) {

            e.printStackTrace()

        }

        val dexOpt = context.getDir("dexOpt", MODE_PRIVATE)

        val classloader = DexClassLoader(
                internalPath,
                dexOpt.absolutePath,
                null,
                context.classLoader)

        resources = FileUtils.getPluginResource(context, internalPath)

        return classloader
    }

    companion object {

        /**
         * 创建一个FileUtils工具类用来将assets目录下的dynamic_dex.jar copy到app/data/cache
         * @param context
         * @param fileName
         * @param desFile
         */
        fun copyFiles(context: Context, fileName: String, desFile: File) {

            var inputStream: InputStream? = null

            var out: OutputStream? = null

            try {

                inputStream = context.applicationContext.assets.open(fileName)

                out = FileOutputStream(desFile.absolutePath)

                val bytes = ByteArray(1024)

                var i: Int = inputStream!!.read(bytes)

                while ((inputStream!!.read(bytes)) != -1) {
                    out.write(bytes, 0, i)
                }

            } catch (e: IOException) {

                e.printStackTrace()

            } finally {

                try {

                    inputStream?.close()

                    out?.close()

                } catch (e: IOException) {

                    e.printStackTrace()

                }

            }
        }


        /**
         * 获取缓存路径
         * @param context
         * @return 返回缓存文件路径
         */

        fun getCacheDir(context: Context): File {
            val cache: File?
            if (hasExternalStorage()) {
                cache = context.externalCacheDir
            } else {
                cache = context.cacheDir

            }
            if (!cache!!.exists()) {
                cache.mkdirs()
            }
            return cache
        }


        fun hasExternalStorage(): Boolean {

            return Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED

        }


        /**
         * 在cache目录 创建一个和文件名一样的文件夹，然后复制asset下dex到这个目录下
         * @param context
         * @param fileName
         */
        fun loadDexClass(context: Context, fileName: String): DexClassLoader {

            val cacheFile = FileUtils.getCacheDir(context.applicationContext)

            val internalPath = cacheFile.absolutePath + File.separator + fileName


            val desFile = File(internalPath)

            try {

                if (!desFile.exists()) {

                    desFile.createNewFile()
                    FileUtils.copyFiles(context, fileName, desFile)
                }

            } catch (e: IOException) {

                e.printStackTrace()

            }

            return DexClassLoader(internalPath, cacheFile.absolutePath, null, context.classLoader)

        }


        fun getPluginResource(context: Context, apkPath: String): Resources {
            val assetManager = createAssetManager(apkPath)
            return Resources(assetManager, context.resources.displayMetrics, context.resources.configuration)
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
    }
}


