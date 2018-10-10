package com.mvvm.executor

import io.reactivex.Scheduler

interface ExecutionThread {

    val scheduler: Scheduler

}