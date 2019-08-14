package com.ustory.relax_basic_component.utils

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast

object ToastUtil { // 对象声明

//    companion object {
//        @SuppressLint("StaticFieldLeak")
//        @Volatile
//        private var instance: ToastUtil? = null
//
//        fun get() =
//            instance ?: synchronized(this) {
//                instance
//                    ?: ToastUtil().also { instance = it }
//            }
//    }



    /**
     * 弹 Toast，字符串类型
     */
    fun show(context:Context,str: String) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }

    /**
     * 弹 Toast，字符串资源id
     */
    fun show(context:Context,@StringRes strResID: Int) {
        show(context,context.getString(strResID))
    }


}
