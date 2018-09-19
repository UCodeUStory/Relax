package com.ustory.relax_basic_component.core.base


import com.ustory.relax_basic_component.core.ICoreService
import com.ustory.relax_basic_component.mvvm.executor.ExecutionThread
import com.ustory.relax_basic_component.mvvm.executor.ThreadExecutor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

/**
 * Created by qiyue on 2018/8/19.
 */
abstract class BaseModel(
        val service: ICoreService
){
    private val threadExecutor: ThreadExecutor = service.threadExecutor
    private val postExecutionThread: ExecutionThread = service.postExecutionThread

    var disposables: CompositeDisposable = CompositeDisposable()


    fun <T:Any> execute(observer: DisposableObserver<T>, target: Observable<T>) {
        val observable = target
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
    }
    /**
     * dispose 后允许再次执行
     */
    open fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
        disposables = CompositeDisposable()
    }

    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }

    inline fun <reified T:ICoreService> asService(): T {
        if (service.javaClass.simpleName.equals(T::class.java.simpleName)){
            return service as T
        }
        throw RuntimeException("服务类型转换错误"+"current = "+service.javaClass.simpleName + "to target="+
                T::class.java.simpleName);
    }



}