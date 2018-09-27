package com.ustory.relax_business_component.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.WindowManager;

import com.ustory.relax_business_component.plugin.inter.IPlugin;


/**
 * 每个插件对应一个代理的ProxyActivity,添加第二个插件需要写一个ProxyActivity2 重写对应的proxyModel即可
 */
public class ProxyActivity extends Activity implements IProxy{

    private ProxyModel mProxyModel;

    protected IPlugin mPluginActivity;

    @Override
    protected void attachBaseContext(Context context) {
        Log.i("qiyue", "proxyActivity=" + context);
        mProxyModel = new ProxyModel(this);
//        mProxyModel.replaceContextResources(context);
        Log.i("old","attachBaseContext");
        super.attachBaseContext(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String className = getIntent().getStringExtra("Class");
        String pluginName = getIntent().getStringExtra("pluginName");
        mProxyModel.onCreate(this,savedInstanceState,pluginName,className);
        Log.i("old","onCreate");
    }


    @Override
    public AssetManager getAssets() {
        Log.i("old","getAssets");
        return mProxyModel.getAssets() == null ? super.getAssets() : mProxyModel.getAssets();
    }

    @Override
    public Resources getResources() {
        Log.i("old","getResources");
        return mProxyModel.getResources() == null ? super.getResources() : mProxyModel.getResources();
    }

    @Override
    public Resources.Theme getTheme() {
        return mProxyModel.getTheme() == null ? super.getTheme() : mProxyModel.getTheme();
    }

    @Override
    public ClassLoader getClassLoader() {
        return mProxyModel.getClassLoader();
    }

    @Override
    public void attach(IPlugin pluginActivity) {
        mPluginActivity = pluginActivity;
    }

    @Override
    protected void onStart() {
        mPluginActivity.onStart();
        super.onStart();
    }

    @Override
    protected void onRestart() {
        mPluginActivity.onRestart();
        super.onRestart();
    }

    @Override
    protected void onResume() {
        mPluginActivity.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mPluginActivity.onPause();
        super.onPause();
    }

    @Override
    protected void onStop() {
        mPluginActivity.onStop();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mPluginActivity.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mPluginActivity.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mPluginActivity.onRestoreInstanceState(savedInstanceState);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        mPluginActivity.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    @Override
    public void onBackPressed() {
        mPluginActivity.onBackPressed();
        super.onBackPressed();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        return mPluginActivity.onTouchEvent(event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode, event);
        return mPluginActivity.onKeyUp(keyCode, event);
    }

    @Override
    public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
        mPluginActivity.onWindowAttributesChanged(params);
        super.onWindowAttributesChanged(params);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        mPluginActivity.onWindowFocusChanged(hasFocus);
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mPluginActivity.onCreateOptionsMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        mPluginActivity.onOptionsItemSelected(item);
        return super.onOptionsItemSelected(item);
    }
}
