package com.ustory.module_business_three.view

import com.mvvm.KoinBaseActivity
import com.ustory.module_business_three.R
import com.ustory.module_business_three.viewmodel.WxNewsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class WxNewsActivity : KoinBaseActivity() {
    override val layoutId: Int
        get() = R.layout.activity_wx_news

    val vm: WxNewsViewModel by viewModel()

    override fun initView() {
    }

    override fun initData() {

    }


}
