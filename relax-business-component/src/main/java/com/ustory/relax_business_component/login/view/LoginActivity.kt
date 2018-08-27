package com.ustory.relax_business_component.login.view

import com.ustory.relax_basic_component.core.BaseActivity
import com.ustory.relax_business_component.R
import com.ustory.relax_business_component.login.model.LoginModel
import com.ustory.relax_business_component.login.viewmodel.LoginViewModel

/**
 * Created by qiyue on 2018/8/24.
 */
class LoginActivity: BaseActivity<LoginViewModel>() {
    override val layoutId: Int
        get() = R.layout.login_activity
    override var initViewModelClass: Class<LoginViewModel>
        get() = LoginViewModel::class.java
        set(value) {}

    override fun initView() {
    }

    override fun initData() {
    }
}