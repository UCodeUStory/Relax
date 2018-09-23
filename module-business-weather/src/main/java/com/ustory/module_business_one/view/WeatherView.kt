package com.ustory.module_business_one.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.ustory.module_business_one.R
import com.ustory.module_business_one.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.weather_layout.view.*

/**
 * Created by qiyue on 2018/7/3.
 */

class WeatherView : RelativeLayout {


    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}


    init {

        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.weather_layout, this, true)
        val weatherViewModel = ViewModelProviders.of(context as AppCompatActivity).get(WeatherViewModel::class.java)
        weatherViewModel.jHWeatherResult.observe( context as AppCompatActivity, Observer {
            val weatherinfoBean = it?.result
            tv_city.text = weatherinfoBean?.today?.city
            tv_temperature.text = weatherinfoBean?.today?.temperature
            tv_time.text = weatherinfoBean?.today?.date_y
            tv_weather.text = weatherinfoBean?.today?.weather
            tv_suggest.text = weatherinfoBean?.today?.dressing_advice
            tv_week.text = weatherinfoBean?.today?.week
        })

        weatherViewModel.findDetailWeather("北京","json",1)



    }

}
