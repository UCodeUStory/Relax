package com.ustory.relax_business_component.businesscase.meizi.usecase

import com.ustory.relax_business_component.businesscase.meizi.model.MeiziPictureModel
import com.ustory.relax_business_component.businesscase.meizi.params.FindMeiziParams
import com.ustory.relax_business_component.core.CoreService
import com.ustory.relax_business_component.core.CoreUseCase
import io.reactivex.Observable

class FindMeiziPictureUseCase( service: CoreService):CoreUseCase<MeiziPictureModel,FindMeiziParams>(service){
    override fun buildUseCaseObservable(params: FindMeiziParams): Observable<MeiziPictureModel> {
       return service.dataService.findMeiZi(params)
    }
}