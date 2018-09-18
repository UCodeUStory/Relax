package com.ustory.relax_business_component.core

import android.content.Context
import com.ustory.relax_basic_component.config.CoreConfig
import com.ustory.relax_basic_component.core.ICoreService
import com.ustory.relax_basic_component.core.base.BaseModel
import com.ustory.relax_data_componet.DataServiceManager
import com.ustory.relax_data_componet.IDataService


/**
 * Created by qiyue on 2018/8/19.
 *
 * 核心服务中包含各种公用服务，所以这个放在基础业务层
 */


class CoreService(
        val appContext: Context,
        val config: CoreConfig
): ICoreService() {

    val netService: IDataService by lazy { DataServiceManager.netDataService  }

    val localService: IDataService by lazy { DataServiceManager.locatDataService }

    val dataService: IDataService = if (config.isOnline) {
        netService
    } else {
        localService
    }

    fun <T : BaseModel> create(factory: (CoreService) -> T): T = factory(this)


}