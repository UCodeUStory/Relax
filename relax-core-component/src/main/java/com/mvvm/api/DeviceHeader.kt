package com.mvvm.api

import android.content.Context
import com.mvvm.utils.DeviceInfoUtil
import com.mvvm.utils.JsonUtil


data class DeviceHeader(
        val uid: String,
        val version: String,
        val screen: String,
        val platform: String = "android",
        val sdk: String = DeviceInfoUtil.getAndroidRelease(),
        val device: String = DeviceInfoUtil.getDeviceModel()
) {

    val json = JsonUtil.toJson(this)

    companion object {

        fun buildScreenInfo(context: Context): String {
            return DeviceInfoUtil.getDensity(context).toString() + ", " +
                    DeviceInfoUtil.getScreenWidth(context) + ", " +
                    DeviceInfoUtil.getScreenHeight(context)
        }

    }

}