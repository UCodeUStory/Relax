package com.ustory.module_business_two.view


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.AttributeSet
import com.ustory.module_business_two.adapter.MeiziListAdapter
import com.ustory.module_business_two.viewmodel.WelfareViewModel
import com.ustory.relax_data_componet.data.MeiziResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean

/**
 * Created by qiyue on 2018/7/10.
 */

class MeiziListView : RecyclerView {

    var meiZiAdapter: MeiziListAdapter

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {}

    init {
        meiZiAdapter = MeiziListAdapter(mutableListOf<ContentlistBean>(), context)
        this.adapter = meiZiAdapter
        val mGridViewLayoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
        layoutManager = mGridViewLayoutManager

        val welfareViewModel = ViewModelProviders.of(context as AppCompatActivity).get(WelfareViewModel::class.java)

//        welfareViewModel.meiziResult.observe(context as AppCompatActivity, Observer {
//            if (it?.showapi_res_body!!.pagebean!!.contentlist != null) {
//                val contentlistBean = it.showapi_res_body!!.pagebean!!.contentlist
//                if (contentlistBean != null) {
//                    meiZiAdapter.initDatas(contentlistBean as MutableList<ContentlistBean>)
//                    meiZiAdapter.notifyDataSetChanged()
//                }
//
//            }
//
//        })
//        welfareViewModel.findMeiZi(1, "4009")

        welfareViewModel.meiziResult2.observe(context as AppCompatActivity, Observer {
            if(it?.data!=null && (it?.data?.size !=0)){

                meiZiAdapter.initDatas2(it.data!!)
                meiZiAdapter.notifyDataSetChanged()
            }
        })
        welfareViewModel.findMeiZiTwo(1)

    }

}
