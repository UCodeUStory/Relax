package com.ustory.relax_business_component.login.view

import android.arch.lifecycle.Observer
import android.widget.Toast
import com.ustory.relax_basic_component.core.BaseActivity
import com.ustory.relax_business_component.R


import com.ustory.relax_business_component.login.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login_activity.*

/**
 * Created by qiyue on 2018/8/24.
 */
class LoginActivity: BaseActivity<LoginViewModel>() {
    override var initViewModelClass: Class<LoginViewModel>
        get() = LoginViewModel::class.java
        set(value) {}
    override val layoutId: Int
        get() = R.layout.login_activity


    override fun initView() {

        btnLogin.setOnClickListener{
            viewmodel.login("123","456234")
        }

        viewmodel.user.observe(this, Observer {
            Toast.makeText(applicationContext,"name="+ it!!.name, Toast.LENGTH_SHORT).show()
        })
    }

    override fun initData() {
    }
}