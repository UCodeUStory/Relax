package com.ustory.relax_basic_component.core

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by qiyue on 2018/8/19.
 */


open class BaseVM :ViewModel(), IRequestStatus {

    override val loading: MutableLiveData<Boolean> = MutableLiveData()

    override val error: MutableLiveData<Throwable> = MutableLiveData()

    inner class BaseObserver<T>(status: IRequestStatus, val listener:(data:T)->Unit) : RequestObserver<T>(status) {
        override fun onNext(data: T) {
            super.onNext(data)
            listener(data)
//            user.value = data
        }
    }

}

