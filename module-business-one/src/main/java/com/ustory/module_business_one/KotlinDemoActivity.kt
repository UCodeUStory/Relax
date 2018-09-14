package com.ustory.module_business_one

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.ustory.relax_basic_component.core.BaseAppCompatActivity
import com.ustory.relax_business_component.R

class KotlinDemoActivity : BaseAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_demo)

        var test = { x: Int, y: Int -> x + y }

        var test2 = { x: Int, y: Int ->
            {
                x + y
                "returnStr"
            }
        }


        //标准写法
        setOnlyLambdaOnClick({ view1, view2 -> { } })

        //函数代码块参数只有一个lambda表达式定义 可以省略()
        setOnlyLambdaOnClick { view1, view2 -> { } }


        //带其他类型参数的写法 1
        setLambdaAndOtherParamOnClick(123,{
            view1,view2 -> {}
        })

        //带其他参数的写法 2 ，这种如果第一眼见到会很懵逼
        setLambdaAndOtherParamOnClick(123){
            view1,view2 ->{}
        }

        //带其他参数的写法 3,如果参数没有用到可以用 _ 代替
        setLambdaAndOtherParamOnClick(123){
            _,_ ->{ }
        }


    }
    // 没有参数的定义必须写个 ()
    fun setNoParamLambdaOnClick(l: (() -> Unit)) {

    }
    // 一个参数的标准写法
    fun setOneLambdaOnClick(l: ((view:View) -> Unit)) {

    }
    // 一个参数的标准写法2 省略变量名字
    fun setOneLambdaOnClick2(l: ((View) -> Unit)) {

    }

    // lambda 可以省略变量名 原型写法（view1:View,view2:View）->Unit
    fun setOnlyLambdaOnClick(l: ((View, View) -> Unit)) {

    }
    // 带普通类型参数和lambda参数方法
    fun setLambdaAndOtherParamOnClick(position:Int,l: ((View, View) -> Unit)) {

    }

}


