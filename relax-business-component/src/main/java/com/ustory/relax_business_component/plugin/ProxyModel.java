package com.ustory.relax_business_component.plugin;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;

import com.ustory.relax_business_component.plugin.inter.IPlugin;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by qiyue on 2018/2/1.
 */

public class ProxyModel {


    private PluginManager pm;

    /**
     * proxyActivity
     */
    private Activity mActivity;
    /**
     * 插件主题
     */
    private Resources.Theme mTheme;

    /**
     * 插件Key
     */
    private String PLUGIN_KEY;

    public ProxyModel(Activity activity){
        mActivity = activity;
        pm = PluginManager.getInstance(activity);
    }

    //notice 通过iProxy接口可以 将公共的操作放到接口里面，从而适配其他类型Activity，否者Activity总变参数也会跟着变，这是简单技巧
    public void onCreate(IProxy iProxy, Bundle savedInstanceState , String pluginName,String className){

        PLUGIN_KEY = pluginName;

        handleActivityInfo();
        Class localClass = null;
        try {
            DexClassLoader dexClassLoader = pm.getClassLoader(PLUGIN_KEY);

            localClass = dexClassLoader.loadClass(className);
            Object instance = localClass.newInstance();

            if (instance != null) {
                Method setProxy = localClass.getMethod("attach", new Class[]{Activity.class});
                setProxy.setAccessible(true);
                setProxy.invoke(instance, new Object[]{iProxy});

                //notice 开始调用插件的onCreate() 建立绑定关系，Proxy和Plugin互相引用
//                Log.i("qiyue", "调用插件onCreate" + savedInstanceState);
                Method onCreate = localClass.getDeclaredMethod("onCreate",
                        new Class[]{Bundle.class});

                //notice 1.先绑定插件，因为下面执行完onCreate后插件的其他方法也会被回调
                iProxy.attach((IPlugin)instance);
                onCreate.setAccessible(true);
                //notice 2.插件再绑定代理，
                onCreate.invoke(instance, new Object[]{null});


            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    private void handleActivityInfo() {
        ActivityInfo mActivityInfo = pm.getActivityInfo(PLUGIN_KEY);

        if (mActivityInfo.theme > 0) {
            mActivity.setTheme(mActivityInfo.theme);
        }
        Resources.Theme superTheme = mActivity.getTheme();

        mTheme = pm.getPluginResources(PLUGIN_KEY).newTheme();

        mTheme.setTo(superTheme);
        // Finals适配三星以及部分加载XML出现异常BUG
        try {
            mTheme.applyStyle(mActivityInfo.theme, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO: handle mActivityInfo.launchMode here in the future.
    }

    public AssetManager getAssets() {
        return pm.getAssets(PLUGIN_KEY);
    }

    public Resources getResources() {
        return pm.getPluginResources(PLUGIN_KEY);
    }

    public Resources.Theme getTheme() {
        return mTheme;
    }

    public ClassLoader getClassLoader() {
        return pm.getClassLoader(PLUGIN_KEY);
    }
}
