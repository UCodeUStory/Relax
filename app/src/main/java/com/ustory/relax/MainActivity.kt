package com.ustory.relax

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ustory.relax_basic_component.core.Person

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var p = Person()
    }
}
