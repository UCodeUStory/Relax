package com.ustory.relax_basic_component.app

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.ustory.relax_basic_component.mvvm.CoreService
import com.ustory.relax_basic_component.mvvm.api.ApiClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
        context = applicationContext
//        var config = ApiClient.Config()
//        updateService(config)
    }


    public lateinit var name:String

    companion object {

        lateinit var service:CoreService
        lateinit var context: Context
        var isServiceReady:Boolean = false

        fun updateService(coreConfig: ApiClient.Config) {
            service = CoreService(context.applicationContext, clientConfig = coreConfig)
            isServiceReady = true
        }
    }
}
