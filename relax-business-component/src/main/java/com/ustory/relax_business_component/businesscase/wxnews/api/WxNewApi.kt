package com.ustory.relax_business_component.businesscase.api

import com.ustory.relax_basic_component.core.CoreContext
import com.ustory.relax_business_component.businesscase.wxnews.mapper.transform
import com.ustory.relax_business_component.businesscase.wxnews.model.WXNewsModel
import com.ustory.relax_business_component.businesscase.wxnews.params.WxNewsParams
import com.ustory.relax_data_componet.data.wxnews.WXNewsRecord
import io.reactivex.Observable

/**
 * CoreService - IDataService - CoreContext (map response,map params) - Retrofit
 */
internal fun CoreContext.buildCloudWxNews(params: WxNewsParams): Observable<WXNewsModel> {
    return wxNewsApiService.findWXNews(params.buildParams()).map(WXNewsRecord::transform)
}