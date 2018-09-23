package com.ustory.relax_data_componet


import com.ustory.relax_data_componet.data.*
import io.reactivex.Observable

/**
 * 具体用什么数据库实现，都可以，对上崔
 */
class LocalDataService: IDataService {
    override fun findSimpleMeizi(page: Int): Observable<MeiZiResult2> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findSimpleWeather(cityName: String): Observable<WeatherResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findDetailWeather(cityname: String, dtype: String, format: Int, key: String): Observable<JHWeatherResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findWXNews(page: Int, pageSize: Int, dtype: String):Observable<WXNewsResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findMeiZi(page: Int, type: String):Observable<MeiziResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}