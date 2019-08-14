package com.ustory.relax_data_componet.retrofit.api.meizi

import com.ustory.relax_data_componet.data.meizi.MeiziPictureRecord
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

//import io.reactivex.Observable;


interface MeiziApiService {

    @GET("852-2")
    fun searchMeiziPicture(@Query("page") page: Int, @Query("type") type: String,
                           @Query("showapi_appid") showapi_appid: String, @Query("showapi_sign") showapi_sign: String): Observable<MeiziPictureRecord>


    @GET("852-2")
    fun searchPicture(@QueryMap params: Map<String, String>): Observable<MeiziPictureRecord>

    companion object {

        val API_GET_MEIZI = "http://route.showapi.com/"

        val API_GET_MEIZI_TWO = "https://www.apiopen.top/"


//        val APP_ID = "69382";

        val APP_ID = "75932"
        //4001 scret
        val secret_4001 = "5BF3E7EAD11FFBCC2208AB4655C046EA"

        //4009
        val secret_4009 = "58d8acc552844fdfb0a50adf1a70acd4"
        //    public static final String secret = "44D406822E2EFB85AF4896FCCE57AE94";

        val secret_4 = ""
    }



}
