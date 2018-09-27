package com.ustory.relax_business_component.plugin;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.lang.reflect.Field;
import java.util.HashMap;

import dalvik.system.DexClassLoader;

/**
 * Created by qiyue on 2018/1/30.
 */

public class PluginManager {

    private String dexOutputPath;
    private String mNativeLibDir;
    private Context mContext;
    private static PluginManager sInstance;

    private HashMap<String,Loader> plugins = new HashMap<>();

    public static PluginManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (PluginManager.class) {
                if (sInstance == null) {
                    sInstance = new PluginManager(context);
                }
            }
        }
        return sInstance;
    }

    private PluginManager(Context context) {
        mContext = context.getApplicationContext();
//        mNativeLibDir = mContext.getDir("pluginlib", Context.MODE_PRIVATE).getAbsolutePath();

    }

    public void loadApk(Plugin plugin){
        Loader loader = new Loader();

        if(checkNewVersion(plugin)){

        }else{
            /**
             * 最好开线程
             */
            int versionCode = loader.loadDefaultPlugin(mContext,plugin.getFileName());
            plugin.setVersion(versionCode);
            plugins.put(plugin.getKey(),loader);
        }

    }

    private boolean checkNewVersion(Plugin plugin) {

        //联网检查是否有新版本 ，如果有就下载，可以在下载到指定目录，然后调用 loader.loadPlugin
        return false;
    }

    public void replaceContextResources(Context context,Resources mResources){
        try {
            Field field = context.getClass().getDeclaredField("mResources");
            field.set(context, mResources);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public HashMap<String, Loader> getPlugins() {
        return plugins;
    }

    public DexClassLoader getClassLoader(String key) {

        if (plugins.containsKey(key)){
            return plugins.get(key).getDexClassLoader();
        }
        return null;
    }

    public Resources getPluginResources(String key) {
        if (plugins.containsKey(key)){
            return plugins.get(key).getResources();
        }
        return null;
    }

    public AssetManager getAssets(String key) {
        if (plugins.containsKey(key)){
            return plugins.get(key).getAssets();
        }
        return null;
    }



    public ActivityInfo getActivityInfo(String key) {
        if (plugins.containsKey(key)){
            return plugins.get(key).getActivityInfo();
        }
        return null;

    }
}
