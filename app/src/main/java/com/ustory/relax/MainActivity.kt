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
            onPermissionDenied{
                toast("失败")
            }
        }.request(this)


    }
}



class Car (
        val model: String?,
        val year: Int
) {
    private constructor(builder: Builder) : this(builder.model, builder.year)

    class Builder {
        var model: String? = null
        var year: Int = -1

        fun build() = Car(this)
    }

    companion object {
         //核心 fun <T> T.apply(f: T.() -> Unit): T { f(); return this }
         //调用者本身扩展一个apply方法, apply 允许可以传递一个无参数的函数无返回值的函数，然后扩展到调用者身上,并在函数体调用这个函数，并放回自身
        // 为什么要Builder.() -> Unit扩展，因为这样里面就可以调用当前对象的其他方法，也就是能使用this
         fun build(a:Int,block: Builder.() -> Unit) = Builder().apply(block).build()
//
         fun build(block: Builder.() -> Unit) = Builder().apply(block).build()


    }
}

// usage
val car = Car.build{
    model = "aa"
    year = 2018
}
// 如果只需要传入一个闭包函数就可以 向上面简单写{}
val car3 = Car.build(22,{
    model = "aa"
    year = 2018
})