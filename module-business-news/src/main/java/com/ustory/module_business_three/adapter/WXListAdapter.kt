package com.ustory.module_business_three.adapter

import android.content.Context
import android.support.annotation.ColorRes
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ustory.module_business_three.R
import com.ustory.relax_business_component.businesscase.wxnews.model.WXNewsModel
import com.ustory.relax_business_component.imageloader.loader

/**
 * create qiyue
 */
class WXListAdapter(datas: List<WXNewsModel.ResultModel.ListModel>, val context: Context) : RecyclerView.Adapter<WXListAdapter.ViewHolder>() {


    var datas: List<WXNewsModel.ResultModel.ListModel> = listOf()

    var mOnClickListener: OnClickListener? = null

    fun setmOnClickListener(mOnClickListener: OnClickListener) {
        this.mOnClickListener = mOnClickListener
    }

    init {
        this.datas = datas
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item, null), parent.context, viewType)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitle.text = datas[position].title
        holder.tvSource.text = datas[position].source
        if(TextUtils.isEmpty(datas[position].firstImg)){
            holder.swImageView.visibility = View.GONE
        }else {
            holder.swImageView.visibility = View.VISIBLE
            holder.swImageView.loader(datas[position].firstImg!!)
        }

    }


    private fun getColor(@ColorRes colorId: Int): Int {
        return context.resources.getColor(colorId)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class ViewHolder(itemView: View, context: Context, itemType: Int) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var tvTitle: TextView
        var tvSource: TextView
        var swImageView: ImageView

        init {
            tvTitle = itemView.findViewById(R.id.tv_title) as TextView
            tvSource = itemView.findViewById(R.id.tv_source) as TextView
            swImageView = itemView.findViewById(R.id.swi_content) as ImageView
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
           mOnClickListener?.onClick(v,position)
        }
    }

    interface OnClickListener {
        fun onClick(view: View, position: Int)

    }
}
