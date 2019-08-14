package com.ustory.relax_business_component.businesscase.wxnews.mapper

import com.ustory.relax_business_component.businesscase.wxnews.model.WXNewsModel
import com.ustory.relax_data_componet.data.wxnews.WXNewsRecord
import com.ustory.relax_data_componet.utils.toNonNullString


fun WXNewsRecord.transform(): WXNewsModel {
    return WXNewsModel(
        this.reason.toNonNullString(),
        this.result?.transform(),
        this.error_code
    )
}

private fun WXNewsRecord.ResultBean.transform(): WXNewsModel.ResultModel {
    return WXNewsModel.ResultModel(
        this.totalPage,
        this.ps,
        this.pno,
        this.list.transform()
    )
}

private fun List<WXNewsRecord.ResultBean.ListBean>?.transform(): List<WXNewsModel.ResultModel.ListModel> {
    return this?.map {
        it?.let {
            WXNewsModel.ResultModel.ListModel(
                it.id ?: "",
                it.title ?: "",
                it.source ?: "",
                it.firstImg ?: "",
                it.mark ?: "",
                it.url ?: ""
            )
        }
    }?.toList() ?: listOf()
}