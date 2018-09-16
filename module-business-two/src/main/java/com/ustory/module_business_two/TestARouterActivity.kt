package com.ustory.module_business_two

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.ustory.relax_basic_component.core.BaseAppCompatActivity

@Route(path = "/moudle2/testARouterActivity")
class TestARouterActivity : BaseAppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_arouter)

    }
}