package com.ustory.relax_business_component.plugin;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import dalvik.system.DexClassLoader;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by qiyue on 2018/2/1.
 */

public class Loader {

    private DexClassLoader dexClassLoader;

    private Resources resources;

    private Context mContext;

    private PackageInfo packageInfo;

    private ActivityInfo mActivityInfo;

    private String mClass;

    private AssetManager assetManager;


    /**
     *
     * @param context
     * @param apkPath
     */
    public void loadPlugin(Context context, String apkPath) {
        mContext = context.getApplicationContext();

        File cacheFile = FileUtils.getCacheDir(context.getApplicationContext());

        String internalPath = cacheFile.getAbsolutePath() + File.separator + apkPath;

        Log.i("qiyue","internalPath="+internalPath);
        File desFile = new File(internalPath);
        try {
            /**
             * 如果第一次初始化默认插件
             */
            if (!desFile.exists()) {
                desFile.createNewFile();
                FileUtils.copyFiles(context, apkPath, desFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        packageInfo = mContext.getPackageManager().getPackageArchiveInfo(internalPath,
                PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);

        if (packageInfo == null) {
            return ;
        }
        File dexOpt = context.getDir("dexOpt", MODE_PRIVATE);
        dexClassLoader = new DexClassLoader(
                internalPath,
                dexOpt.getAbsolutePath(),
                null,
                context.getClassLoader());
        resources = loadPluginResource(context,internalPath);
        initializeActivityInfo();

    }

    public int loadDefaultPlugin(Context context, String fileName) {
        mContext = context.getApplicationContext();

        File cacheFile = FileUtils.getCacheDir(context.getApplicationContext());

        String internalPath = cacheFile.getAbsolutePath() + File.separator + fileName;

        Log.i("qiyue","internalPath="+internalPath);
        File desFile = new File(internalPath);
        try {
            /**
             * 如果第一次初始化默认插件
             */
            if (!desFile.exists()) {
                desFile.createNewFile();
                FileUtils.copyFiles(context, fileName, desFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        packageInfo = mContext.getPackageManager().getPackageArchiveInfo(internalPath,
                PackageManager.GET_ACTIVITIES | PackageManager.GET_SERVICES);

        if (packageInfo == null) {
            return -1;
        }
        File dexOpt = context.getDir("dexOpt", MODE_PRIVATE);
        dexClassLoader = new DexClassLoader(
                internalPath,
                dexOpt.getAbsolutePath(),
                null,
                context.getClassLoader());
        resources = loadPluginResource(context,internalPath);
        initializeActivityInfo();
        return packageInfo.versionCode;

    }


    private Resources loadPluginResource(Context context, String apkPath){
        assetManager = createAssetManager(apkPath);
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



    private void initializeActivityInfo() {

        for (ActivityInfo activityInfo : packageInfo.activities) {
            Log.i("qiyue","activity"+activityInfo.toString());
        }

        if ((packageInfo.activities != null) && (packageInfo.activities.length > 0)) {
            if (mClass == null) {
                mClass = packageInfo.activities[0].name;
            }

            //Finals 修复主题BUG
            int defaultTheme = packageInfo.applicationInfo.theme;
            for (ActivityInfo a : packageInfo.activities) {
                if (a.name.equals(mClass)) {
                    mActivityInfo = a;
                    // Finals ADD 修复主题没有配置的时候插件异常
                    if (mActivityInfo.theme == 0) {
                        if (defaultTheme != 0) {
                            mActivityInfo.theme = defaultTheme;
                        } else {
                            if (Build.VERSION.SDK_INT >= 14) {
                                mActivityInfo.theme = android.R.style.Theme_DeviceDefault;
                            } else {
                                mActivityInfo.theme = android.R.style.Theme;
                            }
                        }
                    }
                }
            }

        }
    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }


    public AssetManager getAssets() {
        return assetManager;
    }

    public ActivityInfo getActivityInfo() {
        return mActivityInfo;
    }
}
