package com.ustory.module_business_two.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.ustory.module_business_two.model.WelfareModel
import com.mvvm.BaseVM
import com.ustory.relax_business_component.app.App
import com.ustory.relax_data_componet.data.MeiZiResult2
import com.ustory.relax_data_componet.data.MeiziResult

class WelfareViewModel : BaseVM() {

    val meiziResult: MutableLiveData<MeiziResult> = MutableLiveData()

    val meiziResult2:MutableLiveData<MeiZiResult2> = MutableLiveData()

    val model = App.coreService.create(::WelfareModel)

    fun findMeiZi(page: Int, type: String) {
        model.findMeizi(page, type, BaseObserver<MeiziResult>(this, {
            meiziResult.value = it
        }))
    }

    fun findMeiZiTwo(page:Int){
        model.findMeiziTWO(page,BaseObserver<MeiZiResult2>(this){
            meiziResult2.value = it
        })
    }

}