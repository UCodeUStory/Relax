package com.ustory.relax_data_componet

/**
 * 数据层通过DataServiceManager动态配置数据服务
 */
object DataServiceManager {

    val netDataService: IDataService by lazy { NetDataService()}

    val locatDataService: IDataService by lazy { LocalDataService()}

}