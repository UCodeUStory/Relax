package com.ustory.relax_business_component.core.viewmodel

import android.arch.lifecycle.Observer
import android.content.Context
import android.support.annotation.CallSuper
import com.ustory.relax_business_component.utils.handleError
import java.lang.ref.WeakReference

open class ErrorObserver(context: Context) : Observer<Throwable> {
    private val weakContext: WeakReference<Context> = WeakReference(context)

    @CallSuper
    override fun onChanged(t: Throwable?) {
        val context = weakContext.get()
        if (context != null) {
            handleError(context, t)
        }
    }

}