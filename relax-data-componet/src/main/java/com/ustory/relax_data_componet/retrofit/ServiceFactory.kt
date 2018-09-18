package com.ustory.relax_data_componet.retrofit


import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Gson: com.squareup.retrofit:converter-gson
 * Jackson: com.squareup.retrofit:converter-jackson
 * Moshi: com.squareup.retrofit:converter-moshi
 * Protobuf: com.squareup.retrofit:converter-protobuf
 * Wire: com.squareup.retrofit:converter-wire
 * Simple XML: com.squareup.retrofit:converter-simplexml
 */
class ServiceFactory {

    val okHttpClient: OkHttpClient
        get() {
            val httpClientBuilder = OkHttpClient.Builder()

            httpClientBuilder.addInterceptor(HttpLoggingInterceptor())
            httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
            httpClientBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)

            return httpClientBuilder.build()
        }


    fun <T> createService(serviceClass: Class<T>, baseUrl: String): T {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//使用RXJava一定要添加
                .build()
        return retrofit.create(serviceClass)
    }

    private object SingletonHolder {
        val INSTANCE = ServiceFactory()
    }

    companion object {
        val instance: ServiceFactory
            get() = SingletonHolder.INSTANCE

        /**
         * 这里上传文件时一定要单独创建一个
         */
        private val DEFAULT_TIMEOUT: Long = 10
    }
}