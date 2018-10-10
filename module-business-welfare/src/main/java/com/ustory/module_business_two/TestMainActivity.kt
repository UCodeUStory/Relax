package com.ustory.module_business_two

import android.arch.lifecycle.Observer
import com.ustory.module_business_two.viewmodel.WelfareViewModel
import com.mvvm.MvvmBaseActivity

class TestMainActivity : MvvmBaseActivity<WelfareViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_maintest
    override var initViewModelClass: Class<WelfareViewModel>
        get() = WelfareViewModel::class.java
        set(value) {}

    override fun initView() {


    }

    override fun initData() {
        viewmodel.findMeiZi(1,"4009")
        viewmodel.meiziResult.observe(this, Observer {
            toast(" 查询成功")
        })
    }



}