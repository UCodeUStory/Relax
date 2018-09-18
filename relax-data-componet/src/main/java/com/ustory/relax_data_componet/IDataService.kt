package com.ustory.relax_data_componet

import com.ustory.relax_data_componet.data.MeiziResult
import io.reactivex.Observable


/**
 * Common API
 */
interface IDataService {

    fun findMeiZi( page:Int, type:String): Observable<MeiziResult>

}