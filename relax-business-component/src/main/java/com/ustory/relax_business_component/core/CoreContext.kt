package com.ustory.relax_basic_component.core

import com.mvvm.executor.ExecutionThread
import com.mvvm.executor.JobExecutor
import com.mvvm.executor.ThreadExecutor
import com.mvvm.executor.UiThread
import com.ustory.relax_business_component.core.BasicData
import com.ustory.relax_data_componet.retrofit.ServiceFactory
import com.ustory.relax_data_componet.retrofit.api.meizi.MeiziApiService
import com.ustory.relax_data_componet.retrofit.api.news.WXNewsApiService
import com.ustory.relax_data_componet.retrofit.api.weather.WeatherApiService
import java.util.concurrent.TimeUnit

/**
 * 核心服务默认配置
 */
abstract class CoreContext(val threadExecutor: ThreadExecutor = JobExecutor(3, 5, 10, TimeUnit.SECONDS),
                           val postExecutionThread: ExecutionThread = UiThread){

    val basicData:BasicData = BasicData()

    val meiziApiService: MeiziApiService = ServiceFactory.instance.createService(MeiziApiService::class.java, MeiziApiService.API_GET_MEIZI)

    val meiziApiService2:MeiziApiService = ServiceFactory.instance.createService(MeiziApiService::class.java, MeiziApiService.API_GET_MEIZI_TWO)

    val wxNewsApiService: WXNewsApiService = ServiceFactory.instance.createService(WXNewsApiService::class.java,WXNewsApiService.WX_NEWS_API)

    val weatherApiService: WeatherApiService = ServiceFactory.instance.createService(WeatherApiService::class.java,WeatherApiService.JH_API_SERVER_URL)


}
