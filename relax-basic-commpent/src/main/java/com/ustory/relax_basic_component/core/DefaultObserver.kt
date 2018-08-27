package com.ustory.relax_basic_component.core

import io.reactivex.observers.DisposableObserver
import timber.log.Timber

/**
 * Created by qiyue on 2018/8/19.
 */
open class DefaultObserver<T> : DisposableObserver<T>() {

    override fun onNext(data: T) {}

    override fun onComplete() {}

    override fun onError(throwable: Throwable) {
        Timber.e(throwable, "onError()")
    }

}