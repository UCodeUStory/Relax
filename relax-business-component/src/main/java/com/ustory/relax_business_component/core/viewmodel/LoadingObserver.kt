package com.ustory.relax_business_component.core.viewmodel

import android.arch.lifecycle.Observer
import timber.log.Timber

class LoadingObserver(
    private val showLoading: (Boolean) -> Unit
) : Observer<Boolean> {
    private var loadingCount: Int = 0

    override fun onChanged(t: Boolean?) {
        if (t == true) {
            ++loadingCount
        } else {
            --loadingCount
        }

        Timber.v("onChanged(): t = $t, loadingCount = $loadingCount")

        if (loadingCount > 0) {
            showLoading(true)
        } else {
            if (loadingCount < 0) {
                loadingCount = 0
            }
            showLoading(false)
        }
    }

}