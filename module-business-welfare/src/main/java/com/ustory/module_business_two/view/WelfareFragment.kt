package com.ustory.module_business_two.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ustory.module_business_two.R
import com.ustory.module_business_two.viewmodel.WelfareViewModel
import com.ustory.relax_business_component.core.BaseFragment
import com.ustory.relax_business_component.core.viewmodel.MdServiceViewModelFactory


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class WelfareFragment : BaseFragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_welfare, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val welfareViewModel = ViewModelProviders.of(activity as FragmentActivity, MdServiceViewModelFactory)
            .get(WelfareViewModel::class.java)
        bindRequestStatus(welfareViewModel)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                WelfareFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
