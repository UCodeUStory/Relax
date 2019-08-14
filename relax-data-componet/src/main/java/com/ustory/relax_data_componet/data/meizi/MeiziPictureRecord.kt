package com.ustory.relax_data_componet.data.meizi

data class MeiziPictureRecord(
    var showapi_res_body: ShowapiResBody?,
    var showapi_res_code: Int?,
    var showapi_res_error: String?,
    var showapi_res_id: String?
)

data class ShowapiResBody(
    var pagebean: Pagebean?,
    var ret_code: Int?
)

data class Pagebean(
    var allNum: Int?,
    var allPages: Int?,
    var contentlist: List<Contentlist>?,
    var currentPage: Int?,
    var maxResult: Int?
)

data class Contentlist(
    var ct: String?,
    var itemId: String?,
    var list: List<X>?,
    var title: String?,
    var type: Int?,
    var typeName: String?
)

data class X(
    var big: String?,
    var middle: String?,
    var small: String?
)