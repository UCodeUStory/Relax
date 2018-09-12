package com.ustory.relax

import android.os.Bundle
import com.ustory.relax_basic_component.core.BaseAppCompatActivity
import com.ustory.relax_business_component.login.view.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_into_login_page.setOnClickListener{
            launcher(LoginActivity::class.java)
        }
    }
}
