package com.ustory.relax_data_componet


import com.ustory.relax_data_componet.data.MeiziResult
import io.reactivex.Observable

/**
 * 具体用什么数据库实现，都可以，对上崔
 */
class LocalDataService: IDataService {
    override fun findMeiZi(): Observable<MeiziResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}