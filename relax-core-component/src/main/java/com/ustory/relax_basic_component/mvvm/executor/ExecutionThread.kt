package com.ustory.relax_basic_component.mvvm.executor

import io.reactivex.Scheduler

interface ExecutionThread {

    val scheduler: Scheduler

}