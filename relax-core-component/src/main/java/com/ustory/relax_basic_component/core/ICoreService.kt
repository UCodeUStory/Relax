package com.ustory.relax_basic_component.core

import com.mvvm.executor.ExecutionThread
import com.mvvm.executor.JobExecutor
import com.mvvm.executor.ThreadExecutor
import com.mvvm.executor.UiThread
import java.util.concurrent.TimeUnit

/**
 * 核心服务默认配置
 */
abstract class ICoreService(val threadExecutor: ThreadExecutor = JobExecutor(3, 5, 10, TimeUnit.SECONDS),
                            val postExecutionThread: ExecutionThread = UiThread){


}
