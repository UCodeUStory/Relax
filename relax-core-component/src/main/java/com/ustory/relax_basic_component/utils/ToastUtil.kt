package com.ustory.relax_basic_component.utils

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast

object ToastUtil { // 对象声明
    /** Context 对象，建议使用 Application */
    private lateinit var mContext: Context

    /**
     * 绑定 Context 对象
     */
    fun bindContext(context: Context) {
        mContext = context
    }

    /**
     * 弹 Toast，字符串类型
     */
    fun show(str: String) {
        Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show()
    }

    /**
     * 弹 Toast，字符串资源id
     */
    fun show(@StringRes strResID: Int) {
        show(mContext.getString(strResID))
    }
}
