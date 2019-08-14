package com.ustory.relax_business_component.login.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.mvvm.BaseVM
import com.ustory.relax_business_component.businesscase.login.model.UserModel


/**
 * Created by qiyue on 2018/8/24.
 */
class LoginViewModel: BaseVM(){

    val user: MutableLiveData<UserModel> = MutableLiveData()

    val user2: MutableLiveData<UserModel> = MutableLiveData()

//    private val loginModel: LoginModel = App.coreService.create(::LoginModel)

    override fun onCleared() {
        super.onCleared()
    }

    fun login(name:String,password:String){
//        loginModel.login(BaseObserver<User>(this,{ user.value = it}),name,password)

    }


//    override fun onCleared() {
//        super.onCleared()
//        loginModel.dispose()
//    }
//
//    val user: MutableLiveData<User> = MutableLiveData()
//
//    val user2:MutableLiveData<User> = MutableLiveData()
//
//    //::引入构造函数
//    private val loginModel: LoginModel = App.service.create(::LoginModel)
//    public fun login( name:String, password:String){
//        Log.i("info","login");
//
////        var callBack = object : NextListener<User>() {
////            override fun onNext(data: User) {
////                user.value = data
////            }
////        }
//
////        loginModel.login(LoginObserver<User>(this,callBack),name,password)
//
//
// 调用Java代码可以这么传递 类名{}
//    loginModel.login(LoginObserver<User>(this,NextListener{ }),name,password)
////
////        loginModel.login(LoginObserver<User>(this,object : NextListener<User>() {
////            override fun onNext(data: User) {
////                user.value = data
////            }
////        }),name,password)
//
//
//
//        loginModel.login(BaseObserver<User>(this,{ user.value = it}),name,password)
//
//    }
//
//
//
//    public fun test(){
//        loginModel.testMaybe(BaseObserver<User>(this,{user2.value = it}))
//    }
////    // 下面就可以，不用每次都写，然后放入Base中
//    abstract class NextListener<T>{
//       abstract fun onNext(data:T)
//    }
//    inner class LoginObserver<T>(status: IRequestStatus,val listener:NextListener<T>) : RequestObserver<T>(status) {
//        override fun onNext(data: T) {
//            super.onNext(data)
//            listener.onNext(data)
////            user.value = data
//        }
//    }
//
////    /**
////     * 通过传入函数的形式代替传入接口的形式，减少类的创建，代码也变得简洁
////     */
}