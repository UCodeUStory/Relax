package com.ustory.relax_basic_component.core.api
import com.google.gson.Gson
import com.ustory.relax_basic_component.BuildConfig
import com.ustory.relax_basic_component.core.ApiService


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by qiyue on 2018/8/23.
 */
class ApiClient(val config: Config) {


    val retrofit:Retrofit

    init {
        val httpClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val original = chain.request()
                    val originalHttpUrl = original.url()

                    val builder = originalHttpUrl.newBuilder()
                            .addQueryParameter("traceID", System.currentTimeMillis().toString())

                    val url = originalHttpUrl.url().toString()
                    if (!url.contains("/bind") &&  !url.contains("/Login")) {
                        builder.addQueryParameter("accessToken", config.accessToken)
                    }

                    val requestBuilder = original.newBuilder()
                            .url(builder.build())
                            .method(original.method(), original.body())

                    if (config.deviceHeader != null) {
                        requestBuilder.addHeader("device", config.deviceHeader.json)
                    }

                    // 登录后才可获得 GroupId
                    val groupId = config.groupId
                    if (groupId.isNotEmpty()) {
                        requestBuilder.addHeader("groupID", groupId)
                    }

                    val request = requestBuilder.build()
                    chain.proceed(request)
                }
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


    fun <T> createApiService(clazz: Class<T>):T{

        return retrofit.create(clazz)

    }

    data class Config(
            val baseUrl: String,
            val port: Int? = null,
            val deviceHeader: DeviceHeader? = null,
            @Volatile var accessToken: String = "",
            @Volatile var groupId: String = "",
            val connectTimeOut: Long = 10,
            val readTimeOut: Long = 10,
            val writeTimeOut: Long = 10
    ) {
        val serverUrl = if (port == null) baseUrl else baseUrl + ":" +  port.toString()
    }

}