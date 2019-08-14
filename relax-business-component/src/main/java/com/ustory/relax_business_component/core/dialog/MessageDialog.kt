package com.ustory.relax_business_component.core.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.ustory.relax_business_component.R
import com.ustory.relax_business_component.utils.toShowOrGone
import kotlinx.android.synthetic.main.dialog_message.*
import kotlinx.android.synthetic.main.partial_dialog_header.*

open class MessageDialog(
        context: Context,
        val title: String,
        val message: String,
        val positiveText: String? = null,
        val onPositiveClickListener: OnMessageDialogButtonClickListener? = null,
        val showPositiveButton: Boolean = true,
        val negativeText: String? = null,
        val onNegativeClickListener: OnMessageDialogButtonClickListener? = null,
        val showNegativeButton: Boolean = false,
        val operationClickListener: OnMessageDialogButtonClickListener? = null,
        val showOperationButton: Boolean = false
) : Dialog(context, R.style.common_dialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_message)
        setCanceledOnTouchOutside(false)
        initView()
    }

    private fun initView() {
        tv_partial_dialog_header_title.text = title

        btn_partial_dialog_header_right.visibility = showPositiveButton.toShowOrGone()
        if (positiveText != null) {
            btn_partial_dialog_header_right.text = positiveText
        }
        btn_partial_dialog_header_right.setOnClickListener {
            it.clearFocus()
            if (onPositiveClickListener != null) {
                onPositiveClickListener.invoke(this)
            } else {
                dismiss()
            }
        }

        btn_partial_dialog_header_left.visibility = showNegativeButton.toShowOrGone()
        if (negativeText != null) {
            btn_partial_dialog_header_left.text = negativeText
        }
        btn_partial_dialog_header_left.setOnClickListener {
            if (onNegativeClickListener != null) {
                onNegativeClickListener.invoke(this)
            } else {
                dismiss()
            }
        }

        tv_message_dialog_message.text = message
        btn_message_dialog_operation.visibility = showOperationButton.toShowOrGone()
        if (operationClickListener != null) {
            btn_message_dialog_operation.setOnClickListener {
                operationClickListener.invoke(this)
            }
        }

    }

}

typealias OnMessageDialogButtonClickListener = (MessageDialog) -> Unit
