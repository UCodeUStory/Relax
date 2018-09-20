package com.ustory.relax_basic_component.mvvm

import android.support.annotation.CallSuper
import java.lang.ref.WeakReference

/**
 * Created by qiyue on 2018/8/19.
 */
abstract class RequestObserver<T>(status: IRequestStatus) : DefaultObserver<T>() {

    protected val status: WeakReference<IRequestStatus> = WeakReference(status)

    @CallSuper
    override fun onStart() {
        super.onStart()
        status.get()?.loading?.value = true
    }

    @CallSuper
    override fun onComplete() {
        super.onComplete()
        status.get()?.loading?.value = false
    }

    @CallSuper
    override fun onError(throwable: Throwable) {
        super.onError(throwable)
        status.get()?.loading?.value = false
        status.get()?.error?.value = throwable
    }

}