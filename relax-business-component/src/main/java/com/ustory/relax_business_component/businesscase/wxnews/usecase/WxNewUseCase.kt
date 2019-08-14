package com.ustory.relax_business_component.businesscase.wxnews.usecase

import com.ustory.relax_business_component.businesscase.wxnews.model.WXNewsModel
import com.ustory.relax_business_component.businesscase.wxnews.params.WxNewsParams
import com.ustory.relax_business_component.core.CoreService
import com.ustory.relax_business_component.core.CoreUseCase
import io.reactivex.Observable

class WxNewUseCase(service: CoreService) : CoreUseCase<WXNewsModel, WxNewsParams>(service) {
    override fun buildUseCaseObservable(params: WxNewsParams): Observable<WXNewsModel> {
        return service.dataService.findWXNews(params)
    }
}