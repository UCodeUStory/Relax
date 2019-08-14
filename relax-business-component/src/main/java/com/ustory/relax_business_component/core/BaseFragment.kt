package com.ustory.relax_business_component.core

import android.content.Intent
import android.support.annotation.CallSuper
import android.support.v4.app.Fragment
import com.mvvm.IRequestStatus

import com.ustory.relax_basic_component.core.dialog.LoadingDialog
import com.ustory.relax_business_component.core.viewmodel.ErrorObserver
import com.ustory.relax_business_component.core.viewmodel.LoadingObserver
import kotlin.reflect.KClass

abstract class BaseFragment : Fragment() {

    val loadingDialog : LoadingDialog? by lazy { context?.let { LoadingDialog(it) } }

    protected val loadingObserver: LoadingObserver by lazy {
        LoadingObserver{
            if (it) {
                loadingDialog?.show()
            } else {
                loadingDialog?.dismiss()
            }
        }
    }

    protected val errorObserver: ErrorObserver? by lazy { context?.let { ErrorObserver(it) } }

    @CallSuper
    protected open fun hideLoading() {
        loadingDialog?.dismiss()
    }

    @CallSuper
    protected open fun showLoading() {
        loadingDialog?.show()
    }

    protected fun bindRequestStatus(source: IRequestStatus) {
        source.loading.observe(this, loadingObserver)
        errorObserver?.let { source.error.observe(this, it) }
    }

    /**
     * 封装启动一个Activity
     */
    fun launch(activityKClass: KClass<*>, getParams: ((Intent) -> Unit)? = null) {
        if (getParams == null) {
            launch(activityKClass)
        }else{
            var intent = Intent(activity, activityKClass.java)
            getParams(intent)
            startActivity(intent)
        }
    }

    fun launch(activityKClass: KClass<*>) {
        startActivity(Intent(activity, activityKClass.java))
    }
}