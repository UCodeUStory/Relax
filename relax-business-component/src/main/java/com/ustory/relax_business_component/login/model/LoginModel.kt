package com.ustory.relax_business_component.login.model

import android.util.Log
import com.ustory.relax.data.User
import com.ustory.relax_basic_component.core.base.BaseModel
import com.ustory.relax_business_component.core.CoreService
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.SingleOnSubscribe
import io.reactivex.observers.DisposableObserver

/**
 * Created by qiyue on 2018/8/24.
 */
class LoginModel(service: CoreService) : BaseModel(service) {

    fun login(observer: DisposableObserver<User>, name:String, password:String){

        // 这里应该调用APIService
        val single: Single<User> =  Single.create(SingleOnSubscribe<User> {

            val user = User("qy","25")

            it.onSuccess(user)
        })

        val userObservable: Observable<User> = single.toObservable()

        Log.i("info","login2")
        execute(observer,userObservable)

    }
}