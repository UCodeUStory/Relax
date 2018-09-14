package com.wangpos.kotlin_s_mvp.base

import android.Manifest
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import com.ustory.relax_basic_component.core.BaseAppCompatActivity
import com.wangpos.kotlin_s_mvp.base.task.SmartTaskManager
import java.lang.reflect.ParameterizedType


/**
 * Created by qiyue on 2016/4/5.
 */
abstract class MVPBaseActivity<P : BasePresenter<*,*>>: BaseAppCompatActivity() {

    abstract var mPresenter: P?
    protected var smartTaskManager: SmartTaskManager? = null;
    abstract var layoutId:Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        initView()


    }

    abstract fun initView()


}
