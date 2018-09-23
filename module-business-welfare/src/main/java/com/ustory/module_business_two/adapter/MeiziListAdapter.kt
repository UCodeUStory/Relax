package com.ustory.module_business_two.adapter

/**
 * Created by qiyue on 2018/7/10.
 */


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ustory.module_business_two.R
import com.ustory.module_business_two.data.OtherBean
import com.ustory.module_business_two.widget.FitXYImageView
import com.ustory.relax_business_component.imageloader.loader
import com.ustory.relax_data_componet.data.MeiziResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean
import com.ustory.relax_data_componet.data.MeiziResult.ShowapiResBodyBean.PagebeanBean.ContentlistBean.ListBean


class MeiziListAdapter : RecyclerView.Adapter<MeiziListAdapter.ItemViewHolder> {

    var mDatas: MutableList<ListBean> = mutableListOf()
    var mOtherBeans: MutableList<OtherBean> = mutableListOf()
    var mContext: Context
    lateinit var mList: List<ContentlistBean>
    constructor(datas: MutableList<ContentlistBean>, context: Context) {
        this.mContext = context
        initDatas(datas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture_grid, parent, false)
        return ItemViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        val viewHolder = holder as ItemViewHolder
        viewHolder.tv_title.setText(mList[position].title)
        viewHolder.iv_picture.loader(mList[position].list!![0].middle!!,R.drawable.error_img)
    }


    class ItemViewHolder : RecyclerView.ViewHolder {
        constructor(view: View) : super(view) {
            tv_title = view.findViewById(R.id.tv_title) as TextView
            iv_picture = view.findViewById(R.id.iv_picture) as FitXYImageView
        }

        var iv_picture: FitXYImageView
        var tv_title: TextView
    }


    private var mOnImageClickListener: OnImageClickListener? = null

    /**
     * 点击条目图片接口
     */
    interface OnImageClickListener {
        fun onImageClick(view: View, position: Int)
    }


    public fun initDatas(list: MutableList<ContentlistBean>) {
        this.mList = list
//        for (data in mList) {
//            //只需要创建一个,减少内存开销
//            val otherBean = OtherBean(data.title, data.ct, data.typeName)
////            for (listBean in data.list!!) {
//                //多个引用指向一个 对象
////                mDatas.add(listBean)
////                mOtherBeans.add(otherBean)
////            }
//
//        }
    }
}
