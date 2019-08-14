package com.ustory.relax_data_componet.retrofit

open class BaseResponse<out T>(
        val code: String? = null,
        val msg: String? = null,
        val success: Boolean? = null,
        val traceID: String? = null,
        val data: T? = null
) {

    val isRequestSuccess: Boolean
        get() = code == "000" && success == true

}
