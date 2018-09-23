package com.ustory.relax_data_componet
import com.ustory.relax_data_componet.data.*
import com.ustory.relax_data_componet.retrofit.ServiceFactory
import com.ustory.relax_data_componet.retrofit.api.meizi.MeiziApiService
import com.ustory.relax_data_componet.retrofit.api.news.WXNewsApiService
import com.ustory.relax_data_componet.retrofit.api.weather.WeatherApiService
import io.reactivex.Observable

class NetDataService: IDataService {
    override fun findSimpleMeizi(page: Int): Observable<MeiZiResult2> {
        return meiziApiService2.findMeiziPicture(page)
    }

    override fun findSimpleWeather(cityName: String): Observable<WeatherResult> {
        return weatherApiService.loadSimpleWeather(cityName)
    }

    override fun findDetailWeather(cityname: String, dtype: String, format: Int, key: String): Observable<JHWeatherResult> {
        return weatherApiService.loadJHWeather(cityname,dtype,format,WeatherApiService.KEY)
    }

    override fun findMeiZi(page: Int, type: String): Observable<MeiziResult> {
       return meiziApiService.searchMeiziPicture(page,type,MeiziApiService.APP_ID,MeiziApiService.secret_4009)
    }

    override fun findWXNews(page: Int, pageSize: Int, dtype: String): Observable<WXNewsResult> {
        return wxNewsApiService.findWXNewsRxJava(page,pageSize,dtype,WXNewsApiService.KEY)
    }

    val meiziApiService:MeiziApiService = ServiceFactory.instance.createService(MeiziApiService::class.java, MeiziApiService.API_GET_MEIZI)

    val meiziApiService2:MeiziApiService = ServiceFactory.instance.createService(MeiziApiService::class.java, MeiziApiService.API_GET_MEIZI_TWO)

    val wxNewsApiService:WXNewsApiService = ServiceFactory.instance.createService(WXNewsApiService::class.java,WXNewsApiService.WX_NEWS_API)

    val weatherApiService:WeatherApiService = ServiceFactory.instance.createService(WeatherApiService::class.java,WeatherApiService.JH_API_SERVER_URL)



}