package com.ustory.relax_basic_component.core

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created by qiyue on 2018/8/19.
 */
abstract class BaseActivity<T : BaseVM>: BaseAppCompatActivity() {
    lateinit var viewmodel:T

    abstract val layoutId:Int
    abstract var initViewModelClass:Class<T>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        viewmodel = ViewModelProviders.of(this).get(initViewModelClass)
//        model.error.observe(this, Observer {  })
        initView()

        initData()
    }



    abstract fun initView()

    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
    }



}