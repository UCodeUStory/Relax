package com.ustory.relax_basic_component.core.executor

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

object UiThread : ExecutionThread {

    override val scheduler: Scheduler = AndroidSchedulers.mainThread()

}