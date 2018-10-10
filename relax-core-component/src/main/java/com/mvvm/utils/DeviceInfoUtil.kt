package com.mvvm.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.wifi.WifiManager
import android.os.Build
import android.text.TextUtils
import com.ustory.relax_basic_component.BuildConfig
import timber.log.Timber
import java.net.NetworkInterface
import java.util.*

object DeviceInfoUtil {
    private val DEVICE_ID_LENGTH = 12

    fun getScreenWidth(context: Context): Int {
        val metrics = context.resources.displayMetrics
        return metrics.widthPixels
    }

    fun getScreenHeight(context: Context): Int {
        val metrics = context.resources.displayMetrics
        return metrics.heightPixels
    }

    fun getDensity(context: Context): Float {
        val metrics = context.resources.displayMetrics
        return metrics.density
    }

    fun buildScreenInfo(context: Context): String =
            (getDensity(context).toString() + ","
                    + getScreenWidth(context) + ","
                    + getScreenHeight(context))


    fun getDeviceModel(): String = Build.MODEL

    fun getAndroidRelease(): String = Build.VERSION.RELEASE

    fun getDeviceId(context: Context): String {
        var deviceId =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) getMacAddressForAndroidM()
                else getMacAddress(context)

        if (BuildConfig.DEBUG) {
            Timber.i("getDeviceId(): deviceId = $deviceId")
        }

        if (deviceId == null) {
            deviceId = getRandomString(DEVICE_ID_LENGTH)
        } else {
            deviceId = Md5Util.calculateMd5(deviceId)
            if (deviceId.length > DEVICE_ID_LENGTH) {
                deviceId = deviceId.substring(DEVICE_ID_LENGTH)
            }
        }
        return deviceId
    }

    @SuppressLint("HardwareIds", "MissingPermission")
    private fun getMacAddress(context: Context): String? {
        val wifi = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        val info = wifi.connectionInfo
        if (BuildConfig.DEBUG) {
            Timber.i("getMacAddress(): info.getMacAddress() = ${info.macAddress}")
        }
        val mac = info.macAddress
        return if (TextUtils.isEmpty(mac)) null else mac.replace("[^A-Za-z0-9]".toRegex(), "")
    }

    private fun getMacAddressForAndroidM(): String? {
        try {
            val all = Collections.list(NetworkInterface.getNetworkInterfaces())
            val nif = all.firstOrNull { it.name.equals("wlan0", ignoreCase = true) }

            if (nif != null) {
                val macBytes = nif.hardwareAddress
                val macAddress = macBytes?.joinToString(separator = "") { String.format("%02X", it) }
                Timber.i("getMacAddressForAndroidM(): macAddress = $macAddress")
                return macAddress
            }
        } catch (e: Exception) {
            Timber.e(e, "getMacAddressForAndroidM()")
        }

        return null
    }

    private fun getRandomString(length: Int): String {
        val str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val random = Random()
        val sb = StringBuilder()

        for (i in 0 until length) {
            val number = random.nextInt(62)//[0,62)
            sb.append(str[number])
        }

        return sb.toString()
    }

}