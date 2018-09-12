package com.ustory.relax_basic_component.config

import com.ustory.relax_basic_component.mvvm.executor.ExecutionThread
import com.ustory.relax_basic_component.mvvm.executor.JobExecutor
import com.ustory.relax_basic_component.mvvm.executor.ThreadExecutor
import com.ustory.relax_basic_component.mvvm.executor.UiThread
import java.util.concurrent.TimeUnit

/**
 * 单例模式
 */
object ConfigMananger{

    val threadExecutor: ThreadExecutor = JobExecutor(3, 5, 10, TimeUnit.SECONDS)
    val postExecutionThread: ExecutionThread = UiThread


}