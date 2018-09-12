package com.ustory.relax_data_componet.init

import com.ustory.relax_basic_component.mvvm.api.ApiClient

/**
 * Created by qiyue on 2018/8/27.
 *
 * application 初始化即可
 */
class DataService(val config: ApiClient.Config) {


    val remoteStoreService : ApiClient by lazy { ApiClient(config) }


    val localStoreService :


}