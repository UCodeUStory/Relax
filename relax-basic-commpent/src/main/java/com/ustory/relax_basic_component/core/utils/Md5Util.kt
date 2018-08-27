package com.ustory.relax_basic_component.core.utils

import java.security.MessageDigest
import java.util.*

object Md5Util {

    fun calculateMd5(str: String): String {
        try {
            val md5 = MessageDigest.getInstance("MD5")
            md5.update(str.toByteArray())
            val result = md5.digest()
            val sb = StringBuilder()
            for (b in result) {
                sb.append(String.format("%02X", b))
            }
            return sb.toString().toLowerCase(Locale.getDefault())
        } catch (e: Throwable) {
            e.printStackTrace()
        }

        return str.hashCode().toString()
    }

}