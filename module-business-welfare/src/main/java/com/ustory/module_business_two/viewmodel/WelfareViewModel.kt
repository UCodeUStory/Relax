package com.ustory.module_business_two.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.mvvm.BaseAVM
import com.ustory.relax_business_component.businesscase.meizi.model.MeiziPictureModel
import com.ustory.relax_business_component.businesscase.meizi.params.FindMeiziParams
import com.ustory.relax_business_component.businesscase.meizi.usecase.FindMeiziPictureUseCase
import com.ustory.relax_business_component.core.CoreService

class WelfareViewModel(application: Application, service: CoreService) : BaseAVM(application) {

    val meiziResult: MutableLiveData<MeiziPictureModel> = MutableLiveData()

    private val findMeiziPictureUseCase = service.create(::FindMeiziPictureUseCase)

    fun findMeiZi(page: Int, type: String) {
        val params = FindMeiziParams(
            page = page.toString(),
            type = type,
            showapi_appid = "75932",
            showapi_sign = "58d8acc552844fdfb0a50adf1a70acd4"
        )
        findMeiziPictureUseCase.execute(params,object:ViewModelObserver<MeiziPictureModel>(){
                override fun onNext(t: MeiziPictureModel) {
                    meiziResult.value = t
                }
            }
        )
    }


    override fun onCleared() {
        super.onCleared()
        findMeiziPictureUseCase.dispose()
    }
}