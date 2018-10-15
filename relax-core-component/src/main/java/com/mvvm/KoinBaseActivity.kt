package com.mvvm

import android.os.Bundle
import com.ustory.relax_basic_component.core.base.BaseAppCompatActivity

abstract class KoinBaseActivity: BaseAppCompatActivity() {

    abstract val layoutId:Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        initView()

        initData()
    }

    abstract fun initView()

    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
    }



}