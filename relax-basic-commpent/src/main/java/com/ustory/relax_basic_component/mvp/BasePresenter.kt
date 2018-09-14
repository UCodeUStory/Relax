package com.wangpos.kotlin_s_mvp.base

/**
 * Created by qiyue on 2018/3/12.
 */

abstract class BasePresenter< V,  M>( val mModel: M) {
    protected var mView: V? = null

//    protected var mModel: M? = null

    fun onAttachedView(v: V) {
        this.mView = v
        this.onAttached()
    }

    abstract fun onAttached()

    fun onDetached() {
        /**
         * 避免内存泄漏
         */
        mView = null
//        mModel = null
    }
}