package com.ustory.module_business_one.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ustory.module_business_one.R
import com.ustory.relax_business_component.login.view.LoginActivity

class WeatherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)



        startActivity(Intent(this,LoginActivity::class.java))
    }
}
