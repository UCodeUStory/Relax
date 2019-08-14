package com.ustory.relax_basic_component.core.dialog

import android.content.Context
import com.ustory.relax_business_component.R
import com.ustory.relax_business_component.core.dialog.MessageDialog
import com.ustory.relax_business_component.core.dialog.OnMessageDialogButtonClickListener


class ErrorDialog(
        context: Context,
        title: String = context.getString(R.string.c_common_error),
        message: String,
        positiveClickListener: OnMessageDialogButtonClickListener? = null
) : MessageDialog(
        context = context,
        title = title,
        message = message,
        onPositiveClickListener = positiveClickListener,
        showPositiveButton = true,
        onNegativeClickListener = null,
        showNegativeButton = false,
        operationClickListener = null,
        showOperationButton = false)
