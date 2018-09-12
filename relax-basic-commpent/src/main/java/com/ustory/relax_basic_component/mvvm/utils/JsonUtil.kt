package com.ustory.relax_basic_component.mvvm.utils

import com.google.gson.Gson

object JsonUtil {

    val gson = Gson()

    fun toJson(src: Any): String = gson.toJson(src)

    inline fun <reified T: Any> fromJson(json: String): T = gson.fromJson(json, T::class.java)

}