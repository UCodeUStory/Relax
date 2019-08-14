package com.ustory.module_business_two.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.AttributeSet
import com.mvvm.ViewObserver
import com.ustory.module_business_two.adapter.MeiziListAdapter
import com.ustory.module_business_two.viewmodel.WelfareViewModel
import com.ustory.relax_business_component.businesscase.meizi.model.ContentlistModel
import com.ustory.relax_business_component.core.viewmodel.MdServiceViewModelFactory

/**
 * Created by qiyue on 2018/7/10.
 */

class MeiziListView : RecyclerView {

    var meiZiAdapter: MeiziListAdapter

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {}

    init {
        meiZiAdapter = MeiziListAdapter(mutableListOf<ContentlistModel>(), context)
        this.adapter = meiZiAdapter
        val mGridViewLayoutManager = StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL)
        layoutManager = mGridViewLayoutManager

        val welfareViewModel = ViewModelProviders.of(context as AppCompatActivity,MdServiceViewModelFactory).get(WelfareViewModel::class.java)

        welfareViewModel.meiziResult.observe(context as AppCompatActivity,
            ViewObserver {
                if (it.showapi_res_body.pagebean.contentlist != null) {
                    val contentlistBean = it.showapi_res_body.pagebean.contentlist
                    if (contentlistBean != null) {
                        meiZiAdapter.initDatas(contentlistBean as MutableList<ContentlistModel>)
                        meiZiAdapter.notifyDataSetChanged()
                    }
                }
            })
        welfareViewModel.findMeiZi(1, "4009")

    }

}
