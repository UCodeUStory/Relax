package com.ustory.module_business_three.view

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ustory.module_business_three.R
import com.ustory.module_business_three.viewmodel.WxNewsViewModel
import com.ustory.relax_business_component.core.BaseFragment
import com.ustory.relax_business_component.core.viewmodel.MdServiceViewModelFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [WxNewsFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [WxNewsFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class WxNewsFragment : BaseFragment() {
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
        return inflater.inflate(R.layout.fragment_wx_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        init()
    }

    private fun init() {
        val wxNewsViewModel = ViewModelProviders.of(activity as FragmentActivity, MdServiceViewModelFactory)
            .get(WxNewsViewModel::class.java)
        bindRequestStatus(wxNewsViewModel)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                WxNewsFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
