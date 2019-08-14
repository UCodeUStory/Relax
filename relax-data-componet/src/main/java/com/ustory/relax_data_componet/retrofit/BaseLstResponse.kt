package com.ustory.relax_data_componet.retrofit

open class BaseLstResponse<out T>(
        val code: String? = null,
        val msg: String? = null,
        val success: Boolean? = null,
        val traceID: String? = null,
        open val data: List<T>? = null
) {

    val isRequestSuccess: Boolean
        get() = code == "000" && success == true

}
