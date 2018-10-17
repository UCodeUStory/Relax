package com.ustory.relax_business_component.app

import android.app.Application
import android.content.Context
import android.os.Build
import com.alibaba.android.arouter.launcher.ARouter
import com.squareup.leakcanary.LeakCanary
import com.ustory.glidebusiness.GlideLoader
import com.ustory.relax_basic_component.config.CoreConfig
import com.ustory.relax_basic_component.utils.ToastUtil
import com.ustory.relax_business_component.core.CoreService
import com.ustory.relax_business_component.imageloader.ImageEngine

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
        /** 初始化ARouter */
        ARouter.init(this)
        /** 初始化全局context */
        context = applicationContext
        /** 初始化图片引擎 */
        ImageEngine.instance.loader = GlideLoader()
        /** 初始化Toast工具 */
        ToastUtil.bindContext(this)
        /** 初始化服务 可以在登陆的时候动态配置 */
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
