package com.ustory.relax_basic_component.utils

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.util.*

class AppManager private constructor() {

    companion object {
        val instance: AppManager by lazy { AppManager() }
    }

    /** 保存 Activity 对象的堆栈 */
    private val activityStack: Stack<AppCompatActivity> = Stack()

    /**
     * 添加 Activity 到堆栈
     *
     * @param activity Activity 对象
     */
    fun addActivity(activity: AppCompatActivity) {
        activityStack.add(activity)
        Log.d("AppManager---->>", "add---->>$activity size---->>${activityStack.size}")
    }

    /**
     * 将 Activity 从堆栈移除
     *
     * @param activity Activity 对象
     */
    fun removeActivity(activity: AppCompatActivity) {
        if (activityStack.contains(activity)) {
            activityStack.remove(activity)
            Log.d("AppManager---->>", "remove---->>$activity size---->>${activityStack.size}")
        }
    }

    /**
     * 结束指定 Activity
     *
     * @param activity Activity 对象
     */
    fun finishActivity(activity: AppCompatActivity) {
        if (activityStack.contains(activity)) {
            activity.finish()
        }
    }

    /**
     * 结束指定 Activity
     *
     * @param cls Activity 类对象
     */
    fun finishActivity(clazz: Class<out AppCompatActivity>) {
        val del: AppCompatActivity? = activityStack.lastOrNull { it.javaClass == clazz }
        del?.finish()
    }

    /**
     * 获取栈顶的 Activity
     *
     * @return 栈顶的 Activity 对象
     */
    fun peekActivity(): AppCompatActivity {
        return activityStack.peek()
    }

    /**
     * 根据类，获取 Activity 对象
     *
     * @param clazz Activity 类
     * @param <T> Activity 类型
     *
     * @return Activity对象
     */
    fun <A : AppCompatActivity> getActivity(clazz: Class<out AppCompatActivity>): A? {
        var target: A? = null
        activityStack
                .filter { it.javaClass == clazz }
                .forEach {
                    @Suppress("UNCHECKED_CAST")
                    target = it as A
                }
        return target
    }

    /**
     * 结束所有Activity
     */
    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
        Log.d("AppManager---->>", "Finish All Activity!")
    }


    /**
     * 退出应用程序
     */
    @SuppressLint("MissingPermission")
    fun appExit() {
        try {
            finishAllActivity()
            val activityMgr = peekActivity().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityMgr.killBackgroundProcesses(peekActivity().packageName)
            System.exit(0)
        } catch (e: Exception) {
            Log.d("AppManager---->>", "Application Exit!")
        }
    }
}
