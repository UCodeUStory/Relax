package com.ustory.relax_business_component.app

import android.app.Application
import android.content.Context
import android.os.Build
import com.alibaba.android.arouter.launcher.ARouter
import com.ustory.relax_basic_component.config.CoreConfig
import com.ustory.relax_business_component.core.CoreService
import com.ustory.relax_business_component.imageloader.ImageEngine
import com.ustory.relax_business_component.imageloader.glide.GlideLoader

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
        context = applicationContext

        ImageEngine.instance.loader = GlideLoader()
        //可以在登陆的时候动态配置
        val coreConfig = CoreConfig("hello", Build.MODEL,true)
        updateService(coreConfig)
    }

    companion object {
        lateinit var coreService: CoreService
        lateinit var context: Context
        var isServiceReady:Boolean = false
        fun updateService(coreConfig:CoreConfig) {
            coreService = CoreService(context.applicationContext, config = coreConfig)
            isServiceReady = true
        }
    }
}
