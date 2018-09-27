package com.ustory.relax_business_component.plugin.inter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000; //需要自己定义标志

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);//关键代码
        setContentView(R.layout.activity_test);

        Log.i("plugin","onCreate");
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Test2Activity.class));
            }
        });
    }
    @Override
    public boolean onKeyDown( int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_HOME) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("plugin","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("plugin","onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("plugin","onDestroy");
    }
}
