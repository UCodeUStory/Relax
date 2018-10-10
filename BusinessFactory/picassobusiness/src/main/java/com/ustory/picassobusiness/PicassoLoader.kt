package com.ustory.picassobusiness

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.ustory.factoryinterface.ILoader

class PicassoLoader :ILoader{
    override fun loadImage(view: ImageView, httpUrl: String, onSuccess: () -> Unit, onError: () -> Unit) {
        Picasso.get().load(httpUrl).into(view)
    }

    override fun loadImage(view: ImageView, httpUrl: String, defaultImage: Int) {
        Picasso.get().load(httpUrl).placeholder(defaultImage).into(view)
    }

    override fun loadImage(view: ImageView, nativeResId: Int) {
        Picasso.get().load(nativeResId).into(view)
    }
}