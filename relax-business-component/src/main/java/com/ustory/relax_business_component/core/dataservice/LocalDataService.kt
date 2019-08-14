package com.ustory.relax_business_component.core.dataservice


import com.ustory.relax_business_component.businesscase.meizi.model.MeiziPictureModel
import com.ustory.relax_business_component.businesscase.meizi.params.FindMeiziParams
import com.ustory.relax_business_component.businesscase.wxnews.model.WXNewsModel
import com.ustory.relax_business_component.businesscase.wxnews.params.WxNewsParams
import com.ustory.relax_data_componet.data.weather.JHWeatherResult
import com.ustory.relax_data_componet.data.weather.WeatherResult
import io.reactivex.Observable

/**
 * 具体用什么数据库实现，都可以，对上崔
 */
class LocalDataService: IDataService {
    override fun findWXNews(params: WxNewsParams): Observable<WXNewsModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findSimpleWeather(cityName: String): Observable<WeatherResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findDetailWeather(cityname: String, dtype: String, format: Int, key: String): Observable<JHWeatherResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findMeiZi(params:FindMeiziParams):Observable<MeiziPictureModel> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}