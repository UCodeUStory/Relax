package com.ustory.relax_business_component.core.dataservice

import com.ustory.relax_basic_component.core.CoreContext
import com.ustory.relax_business_component.businesscase.api.buildCloudWxNews
import com.ustory.relax_business_component.businesscase.meizi.api.buildCloudFindPicture
import com.ustory.relax_business_component.businesscase.meizi.model.MeiziPictureModel
import com.ustory.relax_business_component.businesscase.meizi.params.FindMeiziParams
import com.ustory.relax_business_component.businesscase.wxnews.model.WXNewsModel
import com.ustory.relax_business_component.businesscase.wxnews.params.WxNewsParams
import com.ustory.relax_data_componet.data.weather.JHWeatherResult
import com.ustory.relax_data_componet.data.weather.WeatherResult
import io.reactivex.Observable

class NetDataService(val context: CoreContext) :
    IDataService {


    override fun findDetailWeather(
        cityname: String,
        dtype: String,
        format: Int,
        key: String
    ): Observable<JHWeatherResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findSimpleWeather(cityName: String): Observable<WeatherResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    //    override fun findSimpleMeizi(page: Int): Observable<MeiZiResult2> {
//        return
//    }
//
//    override fun findSimpleWeather(cityName: String): Observable<WeatherResult> {
//        return weatherApiService.loadSimpleWeather(cityName)
//    }
//
//    override fun findDetailWeather(cityname: String, dtype: String, format: Int, key: String): Observable<JHWeatherResult> {
//        return weatherApiService.loadJHWeather(cityname,dtype,format,WeatherApiService.KEY)
//    }
//
    override fun findMeiZi(params: FindMeiziParams): Observable<MeiziPictureModel> {
        return context.buildCloudFindPicture(params)
//       return context.searchMeiziPicture(page,type, MeiziApiService.APP_ID,MeiziApiService.secret_4009)
    }

    override fun findWXNews(params: WxNewsParams): Observable<WXNewsModel> {
        return context.buildCloudWxNews(params)
    }


}