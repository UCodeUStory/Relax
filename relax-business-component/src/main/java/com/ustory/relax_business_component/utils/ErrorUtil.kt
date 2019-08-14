package com.ustory.relax_business_component.utils

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import com.google.gson.JsonSyntaxException
import com.ustory.relax_basic_component.core.dialog.ErrorDialog
import com.ustory.relax_business_component.R
import com.ustory.relax_business_component.exception.NullDataException
import com.ustory.relax_business_component.exception.RequestFailedException
import retrofit2.HttpException
import timber.log.Timber
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun handleError(context: Context,
                throwable: Throwable?,
                onDismissListener: DialogInterface.OnDismissListener? = null) {
    if (context is Activity && context.isFinishing) {
        return
    }

    Timber.e(throwable, "handleError()")
    var title = context.getString(R.string.c_common_error)
    var message = throwable?.message ?: ""
    var overrideListener: DialogInterface.OnDismissListener? = null

    if (throwable is RequestFailedException) {
        val code = throwable.code

        //针对code码做统一处理
    } else if (throwable is NullDataException) {
        //发现数据为null抛出异常
        title = context.getString(R.string.c_error_service_failed)
        message = context.getString(R.string.m_null_response_data)
    } else if (throwable is JsonSyntaxException) {
        title = context.getString(R.string.c_error_service_failed)
        message = context.getString(R.string.m_json_parse_failed)
    } else if (throwable is SocketTimeoutException) {
        title = context.getString(R.string.c_request_timeout)
        message = context.getString(R.string.m_check_network)
    } else if (throwable is ConnectException || throwable is UnknownHostException) {
        title = context.getString(R.string.c_connect_failed)
        message = context.getString(R.string.m_check_network)
    } else if (throwable is HttpException) {
        title = context.getString(R.string.c_http_error)
    } else {
        message = throwable?.message ?: ""
    }

    val dialog = ErrorDialog(
            context = context,
            title = title,
            message = message
    )
    dialog.setOnDismissListener(overrideListener ?: onDismissListener)
    dialog.show()


}
