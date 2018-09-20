package com.ustory.module_business_three.view

import android.arch.lifecycle.Observer
import com.ustory.module_business_three.R
import com.ustory.module_business_three.viewmodel.WxNewsViewModel
import com.ustory.relax_basic_component.mvvm.MvvmBaseActivity

class WxNewsActivity : MvvmBaseActivity<WxNewsViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_wx_news
    override var initViewModelClass: Class<WxNewsViewModel>
        get() = WxNewsViewModel::class.java
        set(value) {}

    override fun initView() {
    }

    override fun initData() {

        viewmodel.wxNewsResult.observe(this, Observer {
            toast("it="+it.toString())

        })
        viewmodel.findWxNews(1,20)
    }


}
