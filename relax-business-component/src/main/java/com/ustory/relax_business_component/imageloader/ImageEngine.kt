package com.ustory.relax_business_component.imageloader

import android.annotation.DrawableRes
import android.widget.ImageView
import com.ustory.relax_business_component.imageloader.ImageEngine.Companion.instance



fun ImageView.loader(url: String) {
    instance.loader.loadImage(this, url,{},{})
}

fun ImageView.loader(url: String,onSuccess:()->Unit) {
    instance.loader.loadImage(this, url,onSuccess,{})
}

fun ImageView.loader(url: String,onSuccess:()->Unit,onError:()->Unit) {
    instance.loader.loadImage(this, url,onSuccess,onError)
}

fun ImageView.loader(@DrawableRes nativeUrl: Int) {
    instance.loader.loadImage(this, nativeUrl)
}

fun ImageView.loader(url: String, @DrawableRes defaultImage: Int) {
    instance.loader.loadImage(this, url, defaultImage)
}

/**
 * 图片加载引擎
 */
class ImageEngine private constructor() {
    //动态初始化
    internal lateinit var loader: ILoader

    companion object {
        val instance: ImageEngine by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            ImageEngine()
        }
    }
}