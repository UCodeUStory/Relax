/*
 * {EasyGank}  Copyright (C) {2015}  {CaMnter}
 *
 * This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; type `show c' for details.
 *
 * The hypothetical commands `show w' and `show c' should show the appropriate
 * parts of the General Public License.  Of course, your program's commands
 * might be different; for a GUI interface, you would use an "about box".
 *
 * You should also get your employer (if you work as a programmer) or school,
 * if any, to sign a "copyright disclaimer" for the program, if necessary.
 * For more information on this, and how to apply and follow the GNU GPL, see
 * <http://www.gnu.org/licenses/>.
 *
 * The GNU General Public License does not permit incorporating your program
 * into proprietary programs.  If your program is a subroutine library, you
 * may consider it more useful to permit linking proprietary applications with
 * the library.  If this is what you want to do, use the GNU Lesser General
 * Public License instead of this License.  But first, please read
 * <http://www.gnu.org/philosophy/why-not-lgpl.html>.
 */

package com.ustory.relax_business_component.imageloader.glide

import android.app.Activity
import android.support.annotation.DrawableRes
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ustory.relax_business_component.imageloader.ILoader


/**
 * @ Author: qiyue (ustory)
 * @ Email: qiyuekoon@foxmail.com
 * @ Data:2016/3/2
 */
class GlideLoader : ILoader {
    override fun loadImage(view: ImageView, httpUrl: String,onSuccess:()->Unit,onError:()->Unit) {
        try {
            Glide.with(view.context)
                    .load(httpUrl)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .centerCrop()
                    .into(view)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun loadImage(view: ImageView, httpUrl: String, @DrawableRes defaultImage: Int) {
        Glide.with(view.context)
                .load(httpUrl)
                .placeholder(defaultImage)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(view)


    }

    override fun loadImage(view: ImageView, nativeResId: Int) {
        // 不能崩
        if (view == null) {
            return
        }
        val context = view.context
        // View你还活着吗？
        if (context is Activity) {
            if (context.isFinishing) {
                return
            }
        }

        try {
            Glide.with(context)
                    .load(nativeResId)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .crossFade()
                    .centerCrop()
                    .into(view).getSize { width, height -> }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private val TAG = "GlideLoader"


}
