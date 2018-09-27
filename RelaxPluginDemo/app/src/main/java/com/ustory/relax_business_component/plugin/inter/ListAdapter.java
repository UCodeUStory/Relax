package com.ustory.relax_business_component.plugin.inter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qiyue on 2018/2/2.
 */

public class ListAdapter extends BaseAdapter {

    Context mContext;

    List<String> datas = new ArrayList<>();

    public ListAdapter(Context context){
        mContext = context;

//        datas.add("Android");
//        datas.add("IOS");
//        datas.add("小程序");
//        datas.add("Python");
        for (int i=0;i<50;i++){
            datas.add("Android "+i);
        }
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (view==null){
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item,null);

            viewHolder = new ViewHolder();
            viewHolder.tvTitle  = (TextView)view.findViewById(R.id.tvTitle);

            view.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvTitle.setText(datas.get(i));

        return view;
    }

    class ViewHolder{
        TextView tvTitle;
    }



}
