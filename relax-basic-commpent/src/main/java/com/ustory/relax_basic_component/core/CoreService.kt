package com.ustory.relax_basic_component.core

import android.content.Context
import com.ustory.relax_basic_component.core.api.ApiClient
import com.ustory.relax_basic_component.core.executor.ExecutionThread
import com.ustory.relax_basic_component.core.executor.JobExecutor
import com.ustory.relax_basic_component.core.executor.ThreadExecutor

import java.util.concurrent.TimeUnit
import com.ustory.relax_basic_component.core.executor.UiThread

/**
 * Created by qiyue on 2018/8/19.
 */


class CoreService(
        val appContext: Context,
        val threadExecutor: ThreadExecutor = JobExecutor(3, 5, 10, TimeUnit.SECONDS),
        val postExecutionThread: ExecutionThread = UiThread,
        val clientConfig: ApiClient.Config
)  {


    val apiClient: ApiClient = ApiClient(clientConfig)

    fun <T : BaseModel> create(factory: (CoreService) -> T): T = factory(this)



}