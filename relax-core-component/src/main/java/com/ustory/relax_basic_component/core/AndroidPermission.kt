package com.wangpos.kotlin_s_mvp.base

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import java.util.ArrayList


/**
 * Created by qiyue on 2018/9/14.
 *
 * 6.0 运行时权限处理工具类。
 */
class AndroidPermission(val builder: Builder) {

    private var mRequestCode = -1

    /**
     * 判断当前手机API版本是否 >= 6.0
     */
    private val isOverMarshmallow: Boolean
        get() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M


    fun request(fragment: android.app.Fragment) {
        requestPermissions(fragment, Companion.mRequestCode, builder.permissions, Companion.mOnPermissionListener)
    }

    fun request(fragment: android.support.v4.app.Fragment) {
        requestPermissions(fragment, Companion.mRequestCode, builder.permissions, Companion.mOnPermissionListener)
    }

    fun request(activity: Activity) {
        requestPermissions(activity, Companion.mRequestCode, builder.permissions, Companion.mOnPermissionListener)
    }

    class Builder {

        var target: Context? = null

        lateinit var permissions: Array<String>

        var permissions_lists: MutableList<String> = mutableListOf()

        var permissionCallBack:OnPermissionListener = object : OnPermissionListener{
            override fun onPermissionGranted() {
                mGrantCallBack()
            }

            override fun onPermissionDenied() {
                mDeniedCallBack()
            }
        }

        // 定义个lambda表达式接收变量
        var mGrantCallBack = {}

        var mDeniedCallBack = {}

        fun requestCode(code: Int) {
            mRequestCode = code
        }

        fun requestPermission(type: String) {
            permissions_lists.add(type)
            permissions = permissions_lists.toTypedArray()
        }

        fun onPermissionGranted(grantedCallback:()->Unit){
            mGrantCallBack = grantedCallback
        }

        fun onPermissionDenied(deniedCallback:()->Unit){
            mDeniedCallBack = deniedCallback
        }

        fun build():AndroidPermission {
            mOnPermissionListener = permissionCallBack
            return AndroidPermission(this)
        }
    }

    companion object {
        //核心 fun <T> T.apply(f: T.() -> Unit): T { f(); return this }
        //调用者本身扩展一个apply方法, apply 允许可以传递一个无参数的函数无返回值的函数，然后扩展到调用者身上,并在函数体调用这个函数，并放回自身
        // 为什么要Builder.() -> Unit扩展，因为这样里面就可以调用当前对象的其他方法，也就是能使用this
        fun build(f: Builder.() -> Unit) = Builder().apply(f).build()

        private var mRequestCode: Int = 0

        private lateinit var mOnPermissionListener: OnPermissionListener

        /**
         * 请求权限结果，对应onRequestPermissionsResult()方法。
         */
        fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
            if (AndroidPermission.mRequestCode != -1 && requestCode == AndroidPermission.mRequestCode) {
                if (AndroidPermission.verifyPermissions(grantResults)) {
                    if (AndroidPermission.mOnPermissionListener != null)
                        AndroidPermission.mOnPermissionListener.onPermissionGranted()
                } else {
                    if (AndroidPermission.mOnPermissionListener != null)
                        AndroidPermission.mOnPermissionListener.onPermissionDenied()
                }
            }
        }

        /**
         * 验证权限是否都已经授权
         */
        private fun verifyPermissions(grantResults: IntArray): Boolean {
            for (grantResult in grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    return false
                }
            }
            return true
        }
    }

    /**
     * 请求权限处理
     *
     * @param object      activity or fragment
     * @param requestCode 请求码
     * @param permissions 需要请求的权限
     * @param callback    结果回调
     */
    @TargetApi(Build.VERSION_CODES.M)
    private fun requestPermissions(obj: Any, requestCode: Int, permissions: Array<String>, callback: OnPermissionListener) {

        checkCallingObjectSuitability(obj)
        mOnPermissionListener = callback

        if (checkPermissions(getContext(obj), *permissions)) {
            if (mOnPermissionListener != null)
                mOnPermissionListener!!.onPermissionGranted()
        } else {
            val deniedPermissions = getDeniedPermissions(getContext(obj), *permissions)
            if (deniedPermissions.size > 0) {
                mRequestCode = requestCode
                if (obj is Activity) {
                    obj.requestPermissions(deniedPermissions
                            .toTypedArray(), requestCode)
                } else if (obj is android.app.Fragment) {
                    obj.requestPermissions(deniedPermissions
                            .toTypedArray(), requestCode)
                } else if (obj is android.support.v4.app.Fragment) {
                    obj.requestPermissions(deniedPermissions
                            .toTypedArray(), requestCode)
                } else {
                    mRequestCode = -1
                }
            }
        }
    }

    /**
     * 获取上下文
     */
    private fun getContext(obj: Any): Context {
        val context: Context
        if (obj is android.app.Fragment) {
            context = obj.activity
        } else if (obj is android.support.v4.app.Fragment) {
            context = obj.activity
        } else {
            context = obj as Activity
        }
        return context
    }

    /**
     * 请求权限结果，对应onRequestPermissionsResult()方法。
     */
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (mRequestCode != -1 && requestCode == mRequestCode) {
            if (verifyPermissions(grantResults)) {
                if (mOnPermissionListener != null)
                    mOnPermissionListener.onPermissionGranted()
            } else {
                if (mOnPermissionListener != null)
                    mOnPermissionListener.onPermissionDenied()
            }
        }
    }

    /**
     * 显示提示对话框
     */
    fun showTipsDialog(context: Context) {
        AlertDialog.Builder(context)
                .setTitle("提示信息")
                .setMessage("当前应用缺少必要权限，该功能暂时无法使用。如若需要，请单击【确定】按钮前往设置中心进行权限授权。")
                .setNegativeButton("取消", null)
                .setPositiveButton("确定") { _, which -> startAppSettings(context) }.show()
    }

    /**
     * 启动当前应用设置页面
     */
    private fun startAppSettings(context: Context) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.data = Uri.parse("package:" + context.packageName)
        context.startActivity(intent)
    }


    /**
     * 获取权限列表中所有需要授权的权限
     *
     * @param context     上下文
     * @param permissions 权限列表
     * @return
     */
    private fun getDeniedPermissions(context: Context, vararg permissions: String): List<String> {
        val deniedPermissions = ArrayList<String>()
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                deniedPermissions.add(permission)
            }
        }
        return deniedPermissions
    }

    /**
     * 检查所传递对象的正确性
     *
     * @param object 必须为 activity or fragment
     */
    private fun checkCallingObjectSuitability(obj: Any?) {
        if (obj == null) {
            throw NullPointerException("Activity or Fragment should not be null")
        }

        val isActivity = obj is Activity
        val isSupportFragment = obj is android.support.v4.app.Fragment
        val isAppFragment = obj is android.app.Fragment

        if (!(isActivity || isSupportFragment || isAppFragment)) {
            throw IllegalArgumentException(
                    "Caller must be an Activity or a Fragment")
        }
    }

    /**
     * 检查所有的权限是否已经被授权
     *
     * @param permissions 权限列表
     * @return
     */
    private fun checkPermissions(context: Context, vararg permissions: String): Boolean {
        if (isOverMarshmallow) {
            for (permission in permissions) {
                if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_DENIED) {
                    return false
                }
            }
        }
        return true
    }

    interface OnPermissionListener {
        fun onPermissionGranted()

        fun onPermissionDenied()
    }

}