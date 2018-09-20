package com.wangpos.kotlin_s_mvp.base.task

import android.util.Log
import java.util.HashMap


/**
 * Created by qiyue on 2017/12/22.
 *
 */

class SmartTaskManager private constructor() {


    internal var stmap: HashMap<String, Asynctask>

    internal var syncTaskMap: HashMap<String, SyncTask>


    val size: Int
        get() = stmap.size


    init {
        this.stmap = HashMap<String, Asynctask>()
        this.syncTaskMap = HashMap<String, SyncTask>()
    }


    /**
     *
     * @param key
     * @param count 线程数量
     */
    fun put(key: String, count: Int): Asynctask {

        synchronized(stmap) {
            val smartTask = Asynctask.newInstance(count)
            stmap[key] = smartTask
            return smartTask
        }

    }

    fun put(tag: String): SyncTask {
        synchronized(syncTaskMap) {
            val syncTask = SyncTask()
            syncTaskMap[tag] = syncTask
            return syncTask
        }


    }

    fun getAsyncTask(key: String): Asynctask? {
        synchronized(stmap) {
            //            for (String s : stmap.keySet()) {
            //
            //                Log.i("info","key="+s);
            //
            //            }
            return stmap[key]
        }
    }


    fun getSyncTask(tag: String): SyncTask? {
        synchronized(syncTaskMap) {
            return syncTaskMap[tag]
        }

    }

    /**
     * remove 调对应的task，否则导致内存泄露，（这里使用sofeRefence还是可以避免的）
     * @param key
     */
    fun remove(key: String) {
        synchronized(stmap) {
            stmap.remove(key)
            Log.i("info", "" + toString())
        }
        synchronized(syncTaskMap) {
            syncTaskMap.remove(key)
        }
    }

    fun clearAll() {
        synchronized(stmap) {
            stmap.clear()
        }
        synchronized(syncTaskMap) {
            syncTaskMap.clear()
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (s in stmap.keys) {
            sb.append("\n")
            sb.append(s)
        }
        return sb.toString()
    }

    companion object {

        @Volatile
        private var smartTaskManager: SmartTaskManager? = null

        fun `as`(): SmartTaskManager? {

            if (smartTaskManager == null) {
                synchronized(SmartTaskManager::class.java) {
                    if (smartTaskManager == null) {
                        smartTaskManager = SmartTaskManager()
                        return smartTaskManager
                    }
                }
            }

            return smartTaskManager
        }
    }
}
