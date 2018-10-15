package com.ustory.relax_business_component.login.view

import android.arch.lifecycle.Observer
import android.widget.Toast
import com.mvvm.KoinBaseActivity
import com.ustory.relax_business_component.R
import com.ustory.relax_business_component.login.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login_activity.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by qiyue on 2018/8/24.
 */
class LoginActivity: KoinBaseActivity() {
    override val layoutId: Int
        get() = R.layout.login_activity

     val vm:LoginViewModel by viewModel()

    override fun initView() {

        btnLogin.setOnClickListener{
            vm.login("123","456234")
        }

        vm.user.observe(this, Observer {
            Toast.makeText(applicationContext,"name="+ it!!.name, Toast.LENGTH_SHORT).show()
        })
    }

    override fun initData() {

    }
}