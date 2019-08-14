package com.mvvm

import io.reactivex.observers.DisposableObserver
import timber.log.Timber

/**
 * Created by qiyue on 2018/8/19.
 */
open abstract class DefaultObserver<T> : DisposableObserver<T>() {

    override fun onComplete() {}

    override fun onError(throwable: Throwable) {
        Timber.e(throwable, "onError()")
    }

}