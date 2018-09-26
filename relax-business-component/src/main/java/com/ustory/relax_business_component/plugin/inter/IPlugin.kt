package com.ustory.relax_business_component.plugin.inter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*

/**
 * Created by qiyue on 2018/1/31.
 */

interface IPlugin {

    fun onCreate(savedInstanceState: Bundle)
    fun onStart()
    fun onRestart()
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent)
    fun onResume()
    fun onPause()
    fun onStop()
    fun onDestroy()
    fun attach(proxyActivity: Activity)
    fun onSaveInstanceState(outState: Bundle)
    fun onNewIntent(intent: Intent)
    fun onRestoreInstanceState(savedInstanceState: Bundle)
    fun onTouchEvent(event: MotionEvent): Boolean
    fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean
    fun onWindowAttributesChanged(params: ViewGroup.LayoutParams)
    fun onWindowFocusChanged(hasFocus: Boolean)
    fun onBackPressed()
    fun onCreateOptionsMenu(menu: Menu): Boolean
    fun onOptionsItemSelected(item: MenuItem): Boolean

    fun startPluginActivity(ClassName: String)


}
