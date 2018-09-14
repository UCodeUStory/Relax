package com.wangpos.kotlin_s_mvp.base

import android.os.Parcel
import android.os.Parcelable
import com.wangpos.kotlin_s_mvp.base.task.SmartTaskManager
import java.lang.reflect.ParameterizedType


/**
 * Created by qiyue on 2016/4/5.
 */
abstract class BaseActivity<P : BasePresenter<*,*>>: BaseAppCompatActivity() {

    var mPresenter: P? = null;
    protected var smartTaskManager: SmartTaskManager? = null;
}
