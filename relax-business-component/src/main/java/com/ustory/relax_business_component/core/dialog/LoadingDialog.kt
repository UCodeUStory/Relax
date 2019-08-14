package com.ustory.relax_basic_component.core.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import com.ustory.relax_business_component.R
import kotlinx.android.synthetic.main.dialog_loading.*

class LoadingDialog(
        context: Context,
        private val message: String? = null,
        private val cancelable: Boolean = false,
        private val cancelOnTouchOutside: Boolean = false
) : Dialog(context, R.style.loading_dialog) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)

        setCanceledOnTouchOutside(cancelOnTouchOutside)
        setCancelable(cancelable)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        initView()
    }

    private fun initView() {
        if (message != null) {
            tv_loading_dialog_message.text = message
        }
    }

}