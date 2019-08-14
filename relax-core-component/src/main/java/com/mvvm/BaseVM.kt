package com.mvvm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by qiyue on 2018/8/19.
 */


open class BaseVM :ViewModel(), IRequestStatus {

    override val loading: MutableLiveData<Boolean> = MutableLiveData()

    override val error: MutableLiveData<Throwable> = MutableLiveData()

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

