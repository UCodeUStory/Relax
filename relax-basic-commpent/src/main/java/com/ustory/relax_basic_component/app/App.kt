package com.ustory.relax_basic_component.app

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
    }


    public lateinit var name:String
}
