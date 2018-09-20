package com.ustory.basic_component.core.executor
import com.ustory.relax_basic_component.mvvm.executor.ThreadExecutor
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.RejectedExecutionHandler
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class SingleThreadExecutor(
        keepAliveTime: Long = 60,
        queueCapacity: Int = 10,
        rejectedExecutionHandler: RejectedExecutionHandler =
                ThreadPoolExecutor.DiscardOldestPolicy()
) : ThreadExecutor {

    private val threadPoolExecutor = ThreadPoolExecutor(1, 1, keepAliveTime, TimeUnit.SECONDS,
            LinkedBlockingQueue<Runnable>(queueCapacity), rejectedExecutionHandler)

    override fun execute(command: Runnable?) {
        threadPoolExecutor.execute(command)
    }

}