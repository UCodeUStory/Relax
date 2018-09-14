package com.wangpos.kotlin_s_mvp.base

import android.os.Handler
import android.os.Looper

/**
 * Created by qiyue on 2018/3/12.
 */
abstract class BaseModel {
    protected var mHandler = Handler(Looper.getMainLooper())
}
