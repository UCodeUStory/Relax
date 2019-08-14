package com.ustory.relax

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import com.ustory.module_business_three.view.WxNewsFragment
import com.ustory.module_business_two.view.WelfareFragment
import com.ustory.relax.adapter.MainViewPagerAdapter
import com.ustory.relax_basic_component.core.base.BaseAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tl_main.setTabTextColors(Color.WHITE, Color.BLACK)
        var datas = mutableListOf<Fragment>()
//        datas.add(WeatherFragment())
        datas.add(WxNewsFragment())
        datas.add(WelfareFragment())

        var titles: Array<String> = arrayOf( "新闻", "福利")

        viewpager_main.adapter = MainViewPagerAdapter(supportFragmentManager, datas, titles)
        tl_main.setupWithViewPager(viewpager_main)


//        AndroidPermission.build {
//            requestCode()
//            requestPermission()
//            onPermissionGranted(mGrantCallBack)
//        }

    }
}
