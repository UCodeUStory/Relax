package com.ustory.module_business_four

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ustory.module_business_plugin.R
import com.ustory.relax_business_component.plugin.Plugin
import com.ustory.relax_business_component.plugin.PluginManager
import com.ustory.relax_business_component.plugin.ProxyActivity
import kotlinx.android.synthetic.main.activity_plugin.*

class PluginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plugin)

        val pluginManager = PluginManager.getInstance(this)
        val plugin = Plugin("app-debug.apk", "learn")
        pluginManager?.loadApk(plugin)
        button_launcher_plugin.setOnClickListener {
            startPluginActivity("learn", "com.ustory.relax_business_component.plugin.inter.WelcomeActivity")
        }
    }

    fun startPluginActivity(pluginName: String, ClassName: String) {
        val intent = Intent(this, ProxyActivity::class.java)
        intent.putExtra("Class", ClassName)
        intent.putExtra("pluginName", pluginName)
        this.startActivity(intent)
    }
}
