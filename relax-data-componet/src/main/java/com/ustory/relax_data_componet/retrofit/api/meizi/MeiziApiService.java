package com.ustory.relax_data_componet.retrofit.api.meizi;

import com.ustory.relax_data_componet.data.MeiziResult;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

//import io.reactivex.Observable;


public interface MeiziApiService {

    String API_GET_MEIZI = "http://route.showapi.com/";


    public static final String APP_ID = "69382";

    //4001 scret
    public static final String secret_4001 = "5BF3E7EAD11FFBCC2208AB4655C046EA";

    //4009
    public static final String secret_4009 = "ED04C0508B0C574EF16B9BCB7A8455FA";
//    public static final String secret = "44D406822E2EFB85AF4896FCCE57AE94";

    @GET("852-2")
    Observable<MeiziResult> searchMeiziPicture(@Query("page") int page, @Query("type") String type,
                                               @Query("showapi_appid") String showapi_appid, @Query("showapi_sign") String showapi_sign);



}
