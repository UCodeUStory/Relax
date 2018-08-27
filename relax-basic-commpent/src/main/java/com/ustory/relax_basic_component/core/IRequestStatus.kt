package com.ustory.relax_basic_component.core

import android.arch.lifecycle.MutableLiveData

/**
 * Created by qiyue on 2018/8/19.
 */
interface IRequestStatus {


    //常量可以交给子类复写
    val loading: MutableLiveData<Boolean>

    val error: MutableLiveData<Throwable>


}