package com.ustory.relax_data_componet
import io.reactivex.Observable
import com.ustory.relax_data_componet.data.MeiziResult
import com.ustory.relax_data_componet.retrofit.RetrofitClient
import com.ustory.relax_data_componet.retrofit.ServiceFactory
import com.ustory.relax_data_componet.retrofit.api.meizi.MeiziApiService

class NetDataService: IDataService {

    val meiziApiService:MeiziApiService = ServiceFactory.instance.createService(MeiziApiService::class.java, MeiziApiService.API_GET_MEIZI)

    override fun findMeiZi(page: Int, type: String): Observable<MeiziResult> {
       return meiziApiService.searchMeiziPicture(page,type,MeiziApiService.APP_ID,MeiziApiService.secret_4009)
    }


}