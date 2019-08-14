package com.ustory.relax_business_component.core

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.mvvm.IRequestStatus
import com.ustory.relax_basic_component.core.dialog.LoadingDialog
import com.ustory.relax_business_component.core.viewmodel.ErrorObserver
import com.ustory.relax_business_component.core.viewmodel.LoadingObserver
import kotlin.reflect.KClass

abstract class BaseActivity : AppCompatActivity() {

    protected val loadingDialog: LoadingDialog by lazy { LoadingDialog(this) }

    protected val loadingObserver: LoadingObserver by lazy {
        LoadingObserver {
            if (it) {
                loadingDialog.show()
            } else {
                loadingDialog.dismiss()
            }
        }
    }

    protected val errorObserver: ErrorObserver by lazy { ErrorObserver(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (this.javaClass.simpleName == "UserLoginActivity"
//            || this.javaClass.simpleName == "RegisterActivity" ||
//            this.javaClass.simpleName == "SplashActivity"
//        ) {

//            if (!App.coreService.basicData.isInitialized) {
//                logout(this)
//                System.exit(0)
//            }

    }

    override fun onResume() {
        super.onResume()
//        if (BuildConfig.isBeta) {
//            WaterMarkUtil.showWatermarkView(this)
//        }
//        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
//        MobclickAgent.onPause(this)
    }
    protected fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = currentFocus ?: View(this)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    protected fun bindRequestStatus(source: IRequestStatus) {
        source.loading.observe(this, loadingObserver)
        source.error.observe(this, errorObserver)
    }

    /**
     * 封装启动一个Activity
     */
    fun launch(activityKClass: KClass<*>, getParams: ((Intent) -> Unit)? = null) {
        if (getParams == null) {
            launch(activityKClass)
        } else {
            var intent = Intent(this, activityKClass.java)
            getParams(intent)
            startActivity(intent)
        }
    }

    /**
     * 封装启动一个Activity
     */
    fun launch(activityKClass: KClass<*>,code:Int, getParams: ((Intent) -> Unit)? = null) {
        if (getParams == null) {
            launch(activityKClass,code)
        } else {
            var intent = Intent(this, activityKClass.java)
            getParams(intent)
            startActivityForResult(intent,code)
        }
    }

    fun launch(activityKClass: KClass<*>,code: Int) {
        startActivityForResult(Intent(this, activityKClass.java),code)
    }

    fun launch(activityKClass: KClass<*>) {
        startActivity(Intent(this, activityKClass.java))
    }
//    protected inner class LoadingObserver : Observer<Boolean> {
//        override fun onChanged(t: Boolean?) {
//            if (t == true) {
//                ++loadingCount
//            } else {
//                --loadingCount
//            }
//
//            Timber.v("onChanged(): t = $t, loadingCount = $loadingCount")
//
//            if (loadingCount > 0) {
//                loadingDialog.show()
//            } else {
//                if (loadingCount < 0) {
//                    loadingCount = 0
//                }
//                loadingDialog.dismiss()
//            }
//        }
//    }

//    protected inner class ErrorObserver : Observer<Throwable> {
//        override fun onChanged(t: Throwable?) {
//            handleError(this@BaseActivity, t)
//        }
//    }

}