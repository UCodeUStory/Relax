package com.ustory.relax_business_component.core.dataservice

import com.ustory.relax_business_component.businesscase.meizi.model.MeiziPictureModel
import com.ustory.relax_business_component.businesscase.meizi.params.FindMeiziParams
import com.ustory.relax_business_component.businesscase.wxnews.model.WXNewsModel
import com.ustory.relax_business_component.businesscase.wxnews.params.WxNewsParams
import com.ustory.relax_data_componet.data.weather.JHWeatherResult
import com.ustory.relax_data_componet.data.weather.WeatherResult
import io.reactivex.Observable


/**
 * Common API
 */
interface IDataService {

    fun findMeiZi( params: FindMeiziParams): Observable<MeiziPictureModel>

    fun findWXNews(params: WxNewsParams): Observable<WXNewsModel>

    fun findDetailWeather( cityname: String,  dtype: String, format: Int, key:String):Observable<JHWeatherResult>

    fun findSimpleWeather(cityName: String):Observable<WeatherResult>


}