package com.ustory.module_business_three.model

import com.ustory.relax_basic_component.core.base.BaseModel
import com.ustory.relax_business_component.core.CoreService
import com.ustory.relax_data_componet.data.WXNewsResult
import io.reactivex.observers.DisposableObserver

class WxNewsModel(service: CoreService) : BaseModel(service) {

    fun findWxNews(page: Int,pageSize:Int, type: String,observer: DisposableObserver<WXNewsResult>) {
        val coreService: CoreService = asService()
        execute(observer, coreService.dataService.findWXNews(page, pageSize,type))
    }

}