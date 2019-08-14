package com.ustory.module_business_three.viewmodel

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.mvvm.BaseAVM
import com.ustory.relax_business_component.businesscase.wxnews.model.WXNewsModel
import com.ustory.relax_business_component.businesscase.wxnews.params.WxNewsParams
import com.ustory.relax_business_component.businesscase.wxnews.usecase.WxNewUseCase
import com.ustory.relax_business_component.core.CoreService

class WxNewsViewModel(application: Application,
                      val service: CoreService
) : BaseAVM(application) {

    val wxNewsResult: MutableLiveData<WXNewsModel> = MutableLiveData()

    val wxNewUseCase = service.create(::WxNewUseCase)

    fun findWxNews(page: Int, pageSize: Int) {
        val params = WxNewsParams(
            page.toString(),
            pageSize.toString(),
            "json"
        )

        wxNewUseCase.execute(params, object : ViewModelObserver<WXNewsModel>() {
            override fun onNext(t: WXNewsModel) {
                wxNewsResult.value = t
            }
        })

    }

}