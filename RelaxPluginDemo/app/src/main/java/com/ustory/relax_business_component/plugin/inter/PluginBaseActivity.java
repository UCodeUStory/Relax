package com.ustory.relax_business_component.plugin.inter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


public class PluginBaseActivity extends Activity implements IPlugin {

    // notice 通过隐式调用宿主的ProxyActivity,这需要全局配置,比如，这个插件给不同宿主用
    public static final String PROXY_VIEW_ACTION = Config.one_package_name;

    // 因为插件的Activity没有Context，所以一切与Context的行为都必须通过宿主代理Activity实现！

    protected Activity that;

    @Override
    public void attach(Activity proxyActivity) {
        that = proxyActivity;

        Log.i("qiyue","attach 11111");
    }

    @Override
    public void setContentView(int layoutResID) {

        if (Config.isInternal){
            super.setContentView(layoutResID);
        }else{
            that.setContentView(layoutResID);
        }

    }


    @Override
    public View findViewById(int id) {

        if (Config.isInternal){
            return super.findViewById(id);
        }else{
            return that.findViewById(id);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i("qiyue","onCreate 1111");
        //notice 如何使内部调试再重定向一下that
        if (Config.isInternal){
            Log.i("qiyue","onCreate 2222");
            super.onCreate(savedInstanceState);
            that = this;
        }
        Log.i("qiyue","onCreate 33333");

    }

    @Override
    public void onStart() {
        if (Config.isInternal){
            super.onStart();
        }
    }

    @Override
    public void onRestart() {
        if (Config.isInternal){
            super.onRestart();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onResume() {
        if (Config.isInternal){
            super.onResume();
        }
    }

    @Override
    public void onPause() {
        if (Config.isInternal){
            super.onPause();
        }
    }

    @Override
    public void onStop() {
        if (Config.isInternal){
            super.onStop();
        }
    }

    @Override
    public void onDestroy() {
        if (Config.isInternal){
            super.onDestroy();
        }
    }



    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onNewIntent(Intent intent) {

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (Config.isInternal){
            return super.onTouchEvent(event);
        }
        return false;
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (Config.isInternal){
            return super.onKeyUp(keyCode,event);
        }
        return false;
    }

    @Override
    public void onWindowAttributesChanged(ViewGroup.LayoutParams params) {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

    }

    @Override
    public void onBackPressed() {
        if (Config.isInternal){
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (Config.isInternal){
            return super.onCreateOptionsMenu(menu);
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (Config.isInternal){
            return super.onOptionsItemSelected(item);
        }
        return false;
    }

    @Override
    public void startPluginActivity(String ClassName) {
        Intent intent = new Intent(PROXY_VIEW_ACTION);
        intent.putExtra("Class", ClassName);
        that.startActivity(intent);
    }



}
