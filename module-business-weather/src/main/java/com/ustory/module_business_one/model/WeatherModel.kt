package com.ustory.module_business_one.model

import com.ustory.relax_basic_component.core.ICoreService
import com.ustory.relax_basic_component.core.base.BaseModel
import com.ustory.relax_business_component.core.CoreService
import com.ustory.relax_data_componet.data.JHWeatherResult
import com.ustory.relax_data_componet.data.WeatherResult
import io.reactivex.observers.DisposableObserver

class WeatherModel(service: ICoreService) : BaseModel(service) {

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
