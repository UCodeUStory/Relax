package com.ustory.relax_basic_component.core

import android.content.Context
import com.ustory.relax_basic_component.config.CoreConfig
import com.ustory.relax_basic_component.core.base.BaseModel
import com.ustory.relax_basic_component.core.base.IDataService
import com.ustory.relax_basic_component.mvvm.executor.ExecutionThread
import com.ustory.relax_basic_component.mvvm.executor.JobExecutor
import com.ustory.relax_basic_component.mvvm.executor.ThreadExecutor

import java.util.concurrent.TimeUnit
import com.ustory.relax_basic_component.mvvm.executor.UiThread

/**
 * Created by qiyue on 2018/8/19.
 */


class CoreService(
        val appContext: Context,
        val threadExecutor: ThreadExecutor = JobExecutor(3, 5, 10, TimeUnit.SECONDS),
        val postExecutionThread: ExecutionThread = UiThread,
        val config: CoreConfig
) {

    val localService: LocalService by lazy { LocalService() }

    val netService: NetService by lazy { NetService() }

    val dataService: IDataService = if (config.isOnline) {
        netService
    } else {
        localService
    }

    fun <T : BaseModel> create(factory: (CoreService) -> T): T = factory(this)


}