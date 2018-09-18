package com.ustory.relax_data_componet

import android.database.Observable
import com.ustory.relax_data_componet.data.MeiziResult


/**
 * Common API
 */
interface IDataService {

    fun findMeiZi():Observable<MeiziResult>

}