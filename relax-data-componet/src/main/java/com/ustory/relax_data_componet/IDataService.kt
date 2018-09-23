package com.ustory.relax_data_componet

import com.ustory.relax_data_componet.data.JHWeatherResult
import com.ustory.relax_data_componet.data.MeiziResult
import com.ustory.relax_data_componet.data.WXNewsResult
import com.ustory.relax_data_componet.data.WeatherResult
import io.reactivex.Observable


/**
 * Common API
 */
interface IDataService {

    fun findMeiZi( page:Int, type:String): Observable<MeiziResult>

    fun findWXNews(page:Int, pageSize:Int, dtype:String): Observable<WXNewsResult>

    fun findDetailWeather( cityname: String,  dtype: String, format: Int, key:String):Observable<JHWeatherResult>

    fun findSimpleWeather(cityName: String):Observable<WeatherResult>


}