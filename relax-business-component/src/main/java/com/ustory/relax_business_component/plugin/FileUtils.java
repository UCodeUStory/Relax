package com.ustory.relax_business_component.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import dalvik.system.DexClassLoader;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by qiyue on 2018/1/30.
 */

public class FileUtils {

    public Resources resources;

    /**
     * 创建一个FileUtils工具类用来将assets目录下的dynamic_dex.jar copy到app/data/cache
     * @param context
     * @param fileName
     * @param desFile
     */
    public static void copyFiles(Context context, String fileName, File desFile) {

        InputStream inputStream = null;

        OutputStream out = null;

        try {

            inputStream = context.getApplicationContext().getAssets().open(fileName);

            out = new FileOutputStream(desFile.getAbsolutePath());

            byte[] bytes = new byte[1024];

            int i;

            while ((i = inputStream.read(bytes)) != -1) {
                out.write(bytes, 0, i);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (inputStream != null)

                    inputStream.close();

                if (out != null)

                    out.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }
    }


    /**
     * 获取缓存路径
     * @param context
     * @return 返回缓存文件路径
     */

    public static File getCacheDir(Context context) {
        File cache;
        if (hasExternalStorage()) {
            cache = context.getExternalCacheDir();
        } else {
            cache = context.getCacheDir();

        }
        if (!cache.exists()) {
            cache.mkdirs();
        }
        return cache;
    }



    public static boolean hasExternalStorage() {

        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

    }


    /**
     * 在cache目录 创建一个和文件名一样的文件夹，然后复制asset下dex到这个目录下
     * @param context
     * @param fileName
     */
    public static DexClassLoader loadDexClass(Context context,String fileName) {

        File cacheFile = FileUtils.getCacheDir(context.getApplicationContext());

        String internalPath = cacheFile.getAbsolutePath() + File.separator + fileName;


        File desFile = new File(internalPath);

        try {

            if (!desFile.exists()) {

                desFile.createNewFile();
                FileUtils.copyFiles(context, fileName, desFile);
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        DexClassLoader dexClassLoader
                = new DexClassLoader(internalPath, cacheFile.getAbsolutePath(), null, context.getClassLoader());

        return dexClassLoader;

    }



    public static Resources getPluginResource(Context context, String apkPath){
        AssetManager assetManager = createAssetManager(apkPath);
        return new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
    }

    private static AssetManager createAssetManager(String apkPath) {
        try {
            AssetManager assetManager = AssetManager.class.newInstance();
            AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(
                    assetManager, apkPath);
            return assetManager;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }


    public  DexClassLoader loadApk(Context context, String fileName) {

        File cacheFile = FileUtils.getCacheDir(context.getApplicationContext());

        String internalPath = cacheFile.getAbsolutePath() + File.separator + fileName;

        Log.i("qiyue","internalPath="+internalPath);
        File desFile = new File(internalPath);

        try {

            if (!desFile.exists()) {

                desFile.createNewFile();
                FileUtils.copyFiles(context, fileName, desFile);
            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        File dexOpt = context.getDir("dexOpt", MODE_PRIVATE);

        final DexClassLoader classloader = new DexClassLoader(
                internalPath,
                dexOpt.getAbsolutePath(),
                null,
                context.getClassLoader());

        resources = FileUtils.getPluginResource(context,internalPath);

        return classloader;
    }
}


