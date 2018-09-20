package com.wangpos.kotlin_s_mvp.base.task

import android.os.Handler
import android.os.Looper
import java.util.concurrent.CountDownLatch


/**
 * Created by qiyue on 2017/12/22.
 */

class Asynctask private constructor(count: Int) {

    internal var latch: CountDownLatch

    internal var endThread: EndThread

    internal var mHandler: Handler

    init {
        mHandler = Handler(Looper.getMainLooper())
        latch = CountDownLatch(count)
        endThread = EndThread()

    }

    fun onFinish() {
        latch.countDown()
    }

    fun toEnd(runnable: Runnable) {
        endThread.setRunnable(runnable)
        endThread.start()
    }

    inner class EndThread : Thread() {

        var runnable: Runnable? = null

        override fun run() {
            super.run()
            try {
                latch.await()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            if (runnable != null) {
                //切换到UI线程
                mHandler.post(runnable)
            } else {
                try {
                    throw EmptyRunnableException("请添加要执行的任务")
                } catch (e: EmptyRunnableException) {
                    e.printStackTrace()
                }

            }
        }
    }


    internal inner class EmptyRunnableException(msg: String) : Exception(msg)

    companion object {

        fun newInstance(count: Int): Asynctask {

            return Asynctask(count)
        }
    }
}

fun Asynctask.EndThread.setRunnable(runnable: Runnable) {
    this.runnable = runnable
}
