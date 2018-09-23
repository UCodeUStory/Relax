package com.ustory.relax.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup

class MainViewPagerAdapter (val fm: FragmentManager,var datas:MutableList<Fragment>,var titles:Array<String>) : FragmentPagerAdapter(fm) {

    //此方法用来显示tab上的名字
    override fun getPageTitle(position: Int): CharSequence {
        return titles[position % titles.size]
    }

    override fun getItem(position: Int): Fragment {
      return datas[position]
    }

    override fun instantiateItem(container: ViewGroup?, position: Int): Any {
        return super.instantiateItem(container, position)
    }

    override fun getCount(): Int {
        return datas.size
    }

}