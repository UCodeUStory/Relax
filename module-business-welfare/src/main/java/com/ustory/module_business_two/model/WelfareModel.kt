package com.ustory.module_business_two.model

import android.util.Log
import com.ustory.relax.data.User
import com.ustory.relax_basic_component.core.ICoreService
import com.ustory.relax_basic_component.core.base.BaseModel
import com.ustory.relax_business_component.core.CoreService
import com.ustory.relax_data_componet.data.MeiziResult
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observers.DisposableObserver

class WelfareModel(service: CoreService) : BaseModel(service) {

    fun findMeizi(page: Int, type: String,observer: DisposableObserver<MeiziResult>) {
        val coreService: CoreService = asService()
        execute(observer, coreService.dataService.findMeiZi(page, type))
    }

}