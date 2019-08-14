package com.ustory.relax_business_component.core

import com.ustory.relax_basic_component.config.CoreConfig
import io.reactivex.disposables.CompositeDisposable
import relax_basic_component.core.base.UseCase

abstract class CoreUseCase<T, in Params>(
        val service: CoreService
) : UseCase<T, Params>(
        threadExecutor = service.threadExecutor,
        postExecutionThread = service.postExecutionThread
) {

    override var disposables: CompositeDisposable = CompositeDisposable()

    protected val config: CoreConfig = service.config

    /**
     * dispose 后允许再次执行 UseCase
     */
    override fun dispose() {
        super.dispose()
        disposables = CompositeDisposable()
    }

}