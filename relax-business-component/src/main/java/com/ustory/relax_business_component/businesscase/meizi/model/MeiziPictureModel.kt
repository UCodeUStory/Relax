package com.ustory.relax_business_component.businesscase.meizi.model

data class MeiziPictureModel(
    val showapi_res_body: ShowapiResBodyModel,
    val showapi_res_code: Int,
    val showapi_res_error: String,
    val showapi_res_id: String
)

data class ShowapiResBodyModel(
    val pagebean: PagebeanModel,
    val ret_code: Int
)

data class PagebeanModel(
    val allNum: Int,
    val allPages: Int,
    val contentlist: List<ContentlistModel>,
    val currentPage: Int,
    val maxResult: Int
)

data class ContentlistModel(
    val ct: String,
    val itemId: String,
    val list: List<XModel>,
    val title: String,
    val type: Int,
    val typeName: String
)

data class XModel(
    val big: String,
    val middle: String,
    val small: String
)