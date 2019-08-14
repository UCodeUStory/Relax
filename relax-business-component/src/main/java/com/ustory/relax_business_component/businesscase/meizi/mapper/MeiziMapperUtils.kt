package com.ustory.relax_business_component.businesscase.meizi.mapper

import com.ustory.relax_business_component.businesscase.meizi.model.*
import com.ustory.relax_data_componet.data.meizi.*
import com.ustory.relax_data_componet.utils.toNonNullInt
import com.ustory.relax_data_componet.utils.toNonNullString

fun MeiziPictureRecord.transform(): MeiziPictureModel {
    return MeiziPictureModel(
        this.showapi_res_body.transform(),
        this.showapi_res_code?.toInt() ?: 0,
        this.showapi_res_error.toNonNullString(),
        this.showapi_res_id.toNonNullString()
    )
}

fun ShowapiResBody?.transform(): ShowapiResBodyModel {
    return ShowapiResBodyModel(
        this?.pagebean.transform(),
        this?.ret_code ?: 0
    )
}

fun Pagebean?.transform(): PagebeanModel {
    return PagebeanModel(
        this?.allNum.toNonNullInt(), this?.allPages.toNonNullInt(), this?.contentlist.transform(),
        this?.currentPage.toNonNullInt(), this?.maxResult.toNonNullInt()
    )
}

fun List<Contentlist>?.transform(): List<ContentlistModel> {
    return this?.asSequence()?.map {
        ContentlistModel(
            it.ct.toNonNullString(),
            it.itemId.toNonNullString(),
            it.list.transformX(),
            it.title.toNonNullString(),
            it.type.toNonNullInt(),
            it.typeName.toNonNullString()
        )
    }?.toList()?: listOf()
}

fun List<X>?.transformX(): List<XModel> {
    val list =  this?.asSequence()?.map {
        XModel(
            it.big.toNonNullString(),
            it.middle.toNonNullString(),
            it.small.toNonNullString()
        )
    }?.toList()?: listOf()

    return list
}

