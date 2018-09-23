package com.ustory.module_business_two.model

import com.ustory.relax_basic_component.core.base.BaseModel
import com.ustory.relax_business_component.core.CoreService
import com.ustory.relax_data_componet.data.MeiZiResult2
import com.ustory.relax_data_componet.data.MeiziResult
import io.reactivex.observers.DisposableObserver

class WelfareModel(service: CoreService) : BaseModel(service) {

    fun findMeizi(page: Int, type: String,observer: DisposableObserver<MeiziResult>) {
        val coreService: CoreService = asService()
        execute(observer, coreService.dataService.findMeiZi(page, type))
    }

    fun findMeiziTWO(page:Int,observer: DisposableObserver<MeiZiResult2>){
        val coreService: CoreService = asService()
        execute(observer, coreService.dataService.findSimpleMeizi(page))
    }

}