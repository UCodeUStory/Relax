package com.ustory.relax.model

import android.util.Log
import com.ustory.relax.data.User
import com.ustory.relax_basic_component.core.BaseModel
import com.ustory.relax_basic_component.core.CoreService
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
//
//    fun testMaybe(observer: DisposableObserver<User>){
//
//       val maybe: Maybe<User> =  Maybe.create(MaybeOnSubscribe<User> {
//            val user = User("qy","255")
//           val user2 = User("qy2","2552")
//            it.onSuccess(user)
////            it.onSuccess(user2) 只能发射一条数据
//        })
//
//        val tt:Single<User> = maybe.toSingle()
//
//        val tt2:Single<User> = tt.onErrorResumeNext(::handleUserNotExist)
//
//        val tt3 :Maybe<User> = tt2.filter {
//            Log.i("info","tt3333")
//            it.name == "qy"
//        }
//        val tt4:Single<User> = tt3.toSingle().onErrorResumeNext(::handleIncorrectPassword)
//
////        val ss:Single<Test> =  tt.map {
////            Test(it)
////        }
//        val ss:Single<User> = tt4
//        val mm = ss.toObservable()
//
//        execute(observer,mm)
//
////        .queryUserById(params.empCode)
////                .toSingle()
////                .onErrorResumeNext(::handleUserNotExist)
////                .filter { it.mdEmpPwd == params.empPWD }
////                .toSingle()
////                .onErrorResumeNext(::handleIncorrectPassword)
////                .map(UserRecord::transform)
////                .toObservable()
//    }
//
////    class Test(user:User){
////
////    }
//
//    private fun handleUserNotExist(throwable: Throwable): Single<User> =
//            mapNoSuchElementException(throwable, Exception("用户不存在"))
//
//
//    private fun handleIncorrectPassword(throwable: Throwable): Single<User> =
//            mapNoSuchElementException(throwable, Exception("密码不正确"))
//
//
//
//    fun <T> mapNoSuchElementException(from: Throwable, to: Throwable): Single<T> {
//        Log.i("info",""+to.message)
//        if (from is NoSuchElementException) {
//            return Single.error<T>(to)
//        } else {
//            return Single.error<T>(from)
//        }
//    }
//
////
////            if (from is NoSuchElementException) {
////                Single.error<T>(to)
////            } else {
////                Single.error<T>(from)
////            }


}