package com.ustory.module_business_one.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.ustory.module_business_one.model.WeatherModel
import com.mvvm.BaseVM
import com.ustory.relax_business_component.app.App
import com.ustory.relax_data_componet.data.weather.JHWeatherResult
import com.ustory.relax_data_componet.data.weather.WeatherResult

class WeatherViewModel: BaseVM() {

    val jHWeatherResult = MutableLiveData<JHWeatherResult>()

    val weatherResult = MutableLiveData<WeatherResult>()

    val model:WeatherModel = App.coreService.create(::WeatherModel)

    fun findDetailWeather(cityName:String,dtype:String,format:Int){
        model.findDetailWeather(cityName,dtype,format,BaseObserver<JHWeatherResult>(this){
            jHWeatherResult.value = it
        })
    }

    fun findSimpleWeather(cityName: String) {
        model.findSimpleWeather(cityName,BaseObserver<WeatherResult>(this){
            weatherResult.value = it
        })
    }

}
