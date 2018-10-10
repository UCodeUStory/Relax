package com.ustory.relax_basic_component.core.base

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.ustory.relax_basic_component.core.AndroidPermission

open class BaseAppCompatActivity : AppCompatActivity() {

    fun toast(msg:String){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }

    fun toast(id:Int){
        Toast.makeText(this,id, Toast.LENGTH_SHORT).show()
    }

    /** kotlin 获取class对象 Class::class.java 或 Class().javaclass **/
    fun launcher(clazz:Class<*>){
        startActivity(Intent(this,clazz))
    }

    fun launcher(clazz:Class<Any>,vararg params:Pair<String,String>){
        startActivity(Intent(this,clazz))
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        AndroidPermission.onRequestPermissionsResult(requestCode, permissions, grantResults)
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }



}