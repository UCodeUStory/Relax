package com.ustory.relax_data_componet.retrofit

import com.google.gson.Gson
import com.ustory.relax_data_componet.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient(val config: Config) {

    val retrofit:Retrofit

    init {
        val httpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(
                        if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.BASIC))
                .connectTimeout(config.connectTimeOut, TimeUnit.SECONDS)
                .readTimeout(config.readTimeOut, TimeUnit.SECONDS)
                .writeTimeout(config.writeTimeOut, TimeUnit.SECONDS)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(config.serverUrl)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    data class Config(
            val baseUrl: String,
            val port: Int? = null,
            val connectTimeOut: Long = 10,
            val readTimeOut: Long = 10,
            val writeTimeOut: Long = 10
    ) {
        val serverUrl = if (port == null) baseUrl else baseUrl + ":" +  port.toString()
    }

}