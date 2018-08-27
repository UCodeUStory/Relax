package com.ustory.relax_basic_component.core.executor

import io.reactivex.Scheduler

interface ExecutionThread {

    val scheduler: Scheduler

}