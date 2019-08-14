package com.ustory.relax_business_component.exception

import com.ustory.relax_data_componet.retrofit.BaseLstResponse
import com.ustory.relax_data_componet.retrofit.BaseResponse

class RequestFailedException(
        message: String?,
        val code: String?
) : RuntimeException(message) {

    constructor(response: BaseResponse<*>?): this(response?.msg, response?.code)

    constructor(response: BaseLstResponse<*>?): this(response?.msg, response?.code)

    override fun toString(): String {
        return "RequestFailedException(code='$code', message='$message')"
    }

}
