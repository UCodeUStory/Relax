### Lambda表达式，本质就是一个匿名函数


可以与任意Java库一起使用

1. 函数式编程提供了一种替换原有复杂的匿名函数定义和创建，就是把函数当作参数传递。使用lambda使代码更加简洁


- 1. 定义写法

   x: Int, y: Int -> String/Unit

- 2. 定义加声明写法 不用写返回值，自动推断最后一行，无返回值最后一行写Unit
    { x: Int, y: Int -> {
               x + y
               "returnStr"
             }
    }

- 3. lambda作为函数参数定义的写法以及 调用时候的传递方法


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