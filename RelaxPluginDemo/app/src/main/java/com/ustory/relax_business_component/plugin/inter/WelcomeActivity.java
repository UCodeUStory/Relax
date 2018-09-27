package com.ustory.relax_business_component.plugin.inter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by qiyue on 2018/1/31.
 */

public class WelcomeActivity extends PluginBaseActivity  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("qiyue","插件onCreate被调用"+savedInstanceState);

        that.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_base);


        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(new ListAdapter(that));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(that,"第"+(position+1)+"条被点击", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
