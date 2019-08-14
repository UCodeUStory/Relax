package com.ustory.relax_business_component.businesscase.wxnews.params

data class WxNewsParams(val page: String, val pageSize: String, val type: String) {
    fun buildParams(): Map<String, String> {
        return mapOf(
            "pno" to page,
            "ps" to pageSize,
            "dtype" to type,
            "key" to "046f0fee45e9891105fea01bb248f5e5"

        )
    }

}