package com.ustory.relax_data_componet.retrofit.api.weather

import com.ustory.relax_data_componet.data.JHWeatherResult
import com.ustory.relax_data_componet.data.WeatherResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WeatherApiService {

    //加载天气
    @GET("adat/sk/{cityId}.html")
    fun loadSimpleWeather(@Path("cityId") cityId: String): Observable<WeatherResult>

    @GET("index")
    fun loadJHWeather(@Query("cityname") cityname: String, @Query("dtype") dtype: String, @Query("format") format: Int, @Query("key") key: String): Observable<JHWeatherResult>

    companion object {
        //免费天气接口
        val API_SERVER_URL = "http://www.weather.com.cn/"

        //聚合天气接口
        val JH_API_SERVER_URL = "http://v.juhe.cn/weather/"

        val KEY = "817a46fd35061aee9512d7826dc19080"
    }
    //
    //    //加载天气
    //    @GET("adat/sk/{cityId}.html")
    //    Observable<WeatherResult> loadDataByRetrofitRxJava(@Path("cityId") String cityId);
}
