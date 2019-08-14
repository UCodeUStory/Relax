package com.ustory.module_business_three.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import com.ustory.module_business_three.adapter.WXListAdapter
import com.ustory.module_business_three.viewmodel.WxNewsViewModel
import com.ustory.relax_business_component.core.viewmodel.MdServiceViewModelFactory
import com.ustory.relax_business_component.webview.WebViewActivity

/**
 * Created by qiyue on 2018/7/6.
 */

class WXNewsListView : RecyclerView,WXListAdapter.OnClickListener {

    private lateinit var mAdapter: WXListAdapter

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {}

    init {
        layoutManager = LinearLayoutManager(context);
        mAdapter = WXListAdapter(mutableListOf(),context)
        mAdapter.setmOnClickListener(this)
        val wxNewsViewModel = ViewModelProviders.of(context as FragmentActivity, MdServiceViewModelFactory).get(WxNewsViewModel::class.java)

        wxNewsViewModel.wxNewsResult.observe(context as AppCompatActivity, Observer {
            mAdapter.datas = it?.result?.list!!
            this.adapter = mAdapter
        })
        wxNewsViewModel.findWxNews(1,30)
    }

    override fun onClick(view: View, position: Int) {
        var data = mAdapter?.datas?.get(position)
        var detailIntent = Intent(context,
            WebViewActivity::class.java)
        detailIntent.putExtra(WebViewActivity.EXTRA_URL, data?.url)
        context.startActivity(detailIntent)

    }
}
