package com.ustory.relax_business_component.businesscase.meizi.params

data class FindMeiziParams(val page: String, val type: String, val showapi_appid: String,val showapi_sign:String) {
    fun buildParams(): Map<String, String> {
        return mapOf(
            "page" to page,
            "type" to type,
            "showapi_appid" to showapi_appid,
            "showapi_sign" to showapi_sign
        )
    }
}
