package com.ustory.module_business_three.view

import com.ustory.module_business_three.R
import com.ustory.module_business_three.viewmodel.WxNewsViewModel
import com.mvvm.MvvmBaseActivity

class WxNewsActivity : MvvmBaseActivity<WxNewsViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_wx_news
    override var initViewModelClass: Class<WxNewsViewModel>
        get() = WxNewsViewModel::class.java
        set(value) {}

    override fun initView() {
    }

    override fun initData() {

    }


}
