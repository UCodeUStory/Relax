package com.ustory.module_business_one.model

import android.os.AsyncTask.execute
import com.ustory.relax_basic_component.core.CoreContext
import com.ustory.relax_business_component.core.CoreService
import com.ustory.relax_data_componet.data.weather.JHWeatherResult
import com.ustory.relax_data_componet.data.weather.WeatherResult
import io.reactivex.observers.DisposableObserver

class WeatherModel(service: CoreContext) : BaseModel(service) {

    fun findDetailWeather(cityname:String,dtype:String,format:Int,observer: DisposableObserver<JHWeatherResult>){
        val coreService:CoreService = asService()

        execute(observer,coreService.dataService.
                findDetailWeather(cityname,dtype,format,""))
    }

    fun findSimpleWeather(cityName: String,observer: DisposableObserver<WeatherResult>) {
        val coreService:CoreService = asService()

//        val observer2 = coreService.dataService.
//                findSimpleWeather(cityName)

        execute(observer,coreService.dataService.
                findSimpleWeather(cityName))
    }

}
