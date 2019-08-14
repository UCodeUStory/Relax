package com.mvvm
import android.arch.lifecycle.Observer

open class ViewObserver<T>(
        private val onChange: ((T) -> Unit)? = null
) : Observer<T> {

    override fun onChanged(t: T?) {
        t?.let { onChange?.invoke(t) }
    }

}