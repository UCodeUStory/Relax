package com.ustory.relax_business_component.utils

import android.app.Activity
import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.support.v4.content.ContextCompat
import android.text.Html
import android.text.TextUtils
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.ustory.relax_basic_component.core.dialog.ErrorDialog
import com.ustory.relax_business_component.R
import com.ustory.relax_business_component.app.App

private const val LONG_SCREEN_RATIO: Float = 16.toFloat() / 10

fun isLongScreen(activity: Activity): Boolean {
    return getScreenRatio(activity) >= LONG_SCREEN_RATIO
}

fun getScreenRatio(activity: Activity): Float {
    val metrics = DisplayMetrics()
    activity.windowManager.defaultDisplay.getMetrics(metrics)
    return if (metrics.heightPixels > metrics.widthPixels) {
        metrics.heightPixels.toFloat() / metrics.widthPixels
    } else {
        metrics.widthPixels.toFloat() / metrics.heightPixels
    }
}

fun Boolean.toShowOrInvisible() =
        if (this) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }

fun Boolean.toShowOrGone() =
        if (this) {
            View.VISIBLE
        } else {
            View.GONE
        }

fun TextView.renderHtml(html: String) {
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
        this.text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        this.text = Html.fromHtml(html)
    }
}


//fun buildDividerDecoration(context: Context): RecyclerView.ItemDecoration {
//    val decoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
//    decoration.setDrawable(ContextCompat.getDrawable(context,
//            R.drawable.s_split_line_horizontal))
//    return decoration
//}

// 由于使用了 DPI 适配，计算 DP 时需要传入当前的 context，不要使用 Application 的 Context
fun dpToPx(context: Context, dp: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
            context.resources.displayMetrics).toInt()
}

fun dpToPx(context: Context, dp: Int): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            context.resources.displayMetrics).toInt()
}

fun formatString(context: Context, resId: Int, vararg args: Any): String =
        String.format(context.getString(resId), *args)

fun formatString(resId: Int, vararg args: Any): String =
        String.format(App.context.getString(resId), *args)

fun Boolean.getName(context: Context): String =
        context.getString(if (this) R.string.c_common_yes else R.string.c_common_no)

operator fun Int.not(): String = App.context.getString(this)

operator fun String.rem(text: Any) = String.format(this, text)

operator fun String.rem(text: Array<Any>) = String.format(this, *text)


fun showError(context: Context, titleId: Int, messageId: Int) {
    ErrorDialog(context,context.getString(titleId),context.getString(messageId)).show()
}

fun showError(context: Context, title: String, message: String) {
    ErrorDialog(context,title,message).show()
}

fun showError(context: Context, titleId: Int, message: String) {
    ErrorDialog(context,context.getString(titleId),message).show()
}

fun showError(context: Context, messageId: Int) {
    ErrorDialog(context,message = context.getString(messageId)).show()
}

fun View.renderEnable(isEnabled: Boolean) {
    this.isEnabled = isEnabled
    this.alpha = if (isEnabled) 1F else 0.5F
}

