package com.ustory.relax

import android.os.Bundle
import com.ustory.module_business_one.KotlinDemoActivity
import com.ustory.relax_basic_component.core.base.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_into_login.setOnClickListener {
//            launcher(LoginActivity::class.java)
            launcher(KotlinDemoActivity::class.java)

//            ARouter.getInstance().build("/moudle1/KotlinDemoActivity").navigation()
        }
















//        btn_into
//        btnLogin.setOnClickListener {  }
//

//        //测试
//        AndroidPermission.build{
//            requestCode(111)
//            requestPermission(Manifest.permission.	WRITE_EXTERNAL_STORAGE)
//            onPermissionGranted{
//                toast("授权成功")
//
//            }
//            onPermissionDenied {
//                toast("授权失败")
//            }
//
//        }.request(this)


    }

}

