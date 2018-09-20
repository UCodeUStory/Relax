package com.ustory.module_business_three.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.ustory.module_business_three.model.WxNewsModel
import com.ustory.relax_basic_component.mvvm.BaseVM
import com.ustory.relax_business_component.app.App
import com.ustory.relax_data_componet.data.WXNewsResult

class WxNewsViewModel: BaseVM() {


    val wxNewsResult: MutableLiveData<WXNewsResult> = MutableLiveData()

    val model = App.coreService.create(::WxNewsModel)

    fun findWxNews(page: Int, pageSize: Int) {
        model.findWxNews(page, pageSize, "json",BaseObserver<WXNewsResult>(this, {
            wxNewsResult.value = it
        }))
    }


}