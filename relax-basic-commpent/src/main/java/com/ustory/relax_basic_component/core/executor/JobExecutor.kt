package com.ustory.relax_basic_component.core.executor

import java.util.concurrent.LinkedBlockingDeque
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class JobExecutor(
        corePoolSize: Int,
        maximumPoolSize: Int,
        keepAliveTime: Long,
        unit: TimeUnit
) : ThreadExecutor {

    private val threadPoolExecutor: ThreadPoolExecutor =
            ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit,
                    LinkedBlockingDeque<Runnable>(), JobThreadFactory())

    override fun execute(command: Runnable?) {
        threadPoolExecutor.execute(command)
    }

    private class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, "android_" + counter++)
        }
    }

}