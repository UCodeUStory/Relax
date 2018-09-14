package com.wangpos.kotlin_s_mvp.base.task

import android.os.Handler
import android.os.Looper
import android.os.Message
import java.util.ArrayList



/**
 * Created by qiyue on 2018/1/5.
 */

class SyncTask {

    internal var mHandler: Handler? = null

    internal var tasks: MutableList<SyncRunnable> = ArrayList<SyncRunnable>()

    internal var currentIndex = -1

    init {
        mHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                currentIndex++

                val runnable = tasks[currentIndex]
                runnable.run(msg.obj)
            }
        }
    }

    /**
     * 按顺序执行
     * @param runnable
     */
    fun onNext(runnable: SyncRunnable): SyncTask {
        tasks.add(runnable)
        return this
    }

    fun onFinish(param: Any) {
        val msg = Message()
        msg.obj = param
        mHandler!!.sendMessage(msg)
    }

    fun start() {
        mHandler!!.sendEmptyMessage(0)
    }

    fun stop() {
        mHandler!!.removeCallbacksAndMessages(null)
        mHandler = null
    }


}
