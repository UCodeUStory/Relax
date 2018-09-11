package com.ustory.relax.app

import android.app.Application
import android.os.Build
import com.ustory.relax_basic_component.BuildConfig
import com.ustory.relax_basic_component.core.CoreService
import com.ustory.relax_basic_component.core.api.ApiClient
import com.ustory.relax_basic_component.core.api.DeviceHeader
import com.ustory.relax_basic_component.core.utils.DeviceInfoUtil

/**
 * Created by qiyue on 2018/8/24.
 */
class App : Application() {


    companion object {
        lateinit var service: CoreService
        val server = "http://www.weather.com.cn/"

    }

    override fun onCreate() {
        super.onCreate()


        val deviceId = DeviceInfoUtil.getDeviceId(applicationContext)
        val deviceHeader = DeviceHeader(
                uid = deviceId,
                version = BuildConfig.VERSION_NAME,
                screen = DeviceInfoUtil.buildScreenInfo(applicationContext),
                device = Build.MODEL
        )

        service = CoreService(applicationContext, clientConfig = ApiClient.Config(
                baseUrl = server,
                deviceHeader = deviceHeader
        ))
    }

}