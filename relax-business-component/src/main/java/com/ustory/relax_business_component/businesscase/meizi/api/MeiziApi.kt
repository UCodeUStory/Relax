package com.ustory.relax_business_component.businesscase.meizi.api

import com.ustory.relax_basic_component.core.CoreContext
import com.ustory.relax_business_component.businesscase.meizi.mapper.transform
import com.ustory.relax_business_component.businesscase.meizi.model.MeiziPictureModel
import com.ustory.relax_business_component.businesscase.meizi.params.FindMeiziParams
import com.ustory.relax_data_componet.data.meizi.MeiziPictureRecord
import io.reactivex.Observable

internal fun CoreContext.buildCloudFindPicture(params: FindMeiziParams): Observable<MeiziPictureModel> {
    return meiziApiService.searchPicture(params.buildParams()).map(MeiziPictureRecord::transform)
}