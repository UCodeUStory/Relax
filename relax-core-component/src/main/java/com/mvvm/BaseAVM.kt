package com.mvvm

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Context

abstract class BaseAVM(
        application: Application
): AndroidViewModel(application), IRequestStatus {

    val appContext: Context
        get() = getApplication()

    override val loading: MutableLiveData<Boolean> = MutableLiveData()

    override val error: MutableLiveData<Throwable> = MutableLiveData()

    protected fun getString(resId: Int) = appContext.getString(resId)

    protected fun publishError(throwable: Throwable) {
        error.value = throwable
    }

    protected fun publishError(factory: (String) -> Throwable, messageResId: Int) {
        publishError(factory(getString(messageResId)))
    }

    abstract inner class ViewModelObserver<T> : DefaultObserver<T>() {
        override fun onStart() {
            super.onStart()
            loading.value = true
        }

        override fun onError(throwable: Throwable) {
            super.onError(throwable)
            loading.value = false
            error.value = throwable
        }

        override fun onComplete() {
            super.onComplete()
            loading.value = false
        }
    }

}