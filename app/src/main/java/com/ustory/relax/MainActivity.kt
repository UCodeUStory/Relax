package com.ustory.relax

import android.Manifest
import android.app.Dialog
import android.os.Bundle
import com.ustory.relax_basic_component.core.BaseAppCompatActivity
import com.ustory.relax_business_component.login.view.LoginActivity
import com.wangpos.kotlin_s_mvp.base.AndroidPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_into_login_page.setOnClickListener{
            launcher(LoginActivity::class.java)
        }

        //测试
        AndroidPermission.build{
            requestCode(111)
            requestPermission(Manifest.permission.	WRITE_EXTERNAL_STORAGE)
            onPermissionGranted{
                toast("授权成功")

            }
            onPermissionDenied {
                toast("授权失败")
            }

        }.request(this)


    }
}

