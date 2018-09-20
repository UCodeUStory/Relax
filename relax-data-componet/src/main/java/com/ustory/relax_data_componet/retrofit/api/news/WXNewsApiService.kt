package com.ustory.relax_data_componet.retrofit.api.news


import com.ustory.relax_data_componet.data.WXNewsResult
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by qiyue on 2018/7/5.
 */

interface WXNewsApiService {

    @GET("query")
    fun findWXNews(@Query("pno") pno: Int, @Query("ps") ps: Int, @Query("dtype") dtype: String, @Query("key") key: String): Call<WXNewsResult>

    @GET("query")
    fun findWXNewsRxJava(@Query("pno") pno: Int, @Query("ps") ps: Int, @Query("dtype") dtype: String, @Query("key") key: String): Observable<WXNewsResult>

    companion object {

        /**
         * 聚合数据
         */

        val WX_NEWS_API = "http://v.juhe.cn/weixin/"

        val KEY = "046f0fee45e9891105fea01bb248f5e5"
    }


}
