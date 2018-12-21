### Kotlin 学习笔记，主要是难点解决

    这里并不是教程，以下内容有可能是你在学习了一些kotlin语法后仍然不解的问题，皆在这里帮你找到答案

1. [闭包closure详解](https://github.com/UCodeUStory/Relax/tree/master/source/closure.md)
2. [lambda表达式](https://github.com/UCodeUStory/Relax/tree/master/source/lambda.md)
3. [集合转序列化再进行链式调用，减少中间集合的创建](https://github.com/UCodeUStory/Relax/tree/master/source/sequence.md)
4. [kotlin遍历map foreach报错](https://github.com/UCodeUStory/Relax/tree/master/source/kotlin_map_error.md)
5. [kotlin 自带内联函数详解](https://github.com/UCodeUStory/Relax/tree/master/source/kotlin_inline.md)
6. [object、comval 和 const区别](https://github.com/UCodeUStory/Relax/tree/master/source/kotlin_val_const.md)
7. [kotlin 1.3新特性之 @JvmStatic 和 @JvmField 注解](https://github.com/UCodeUStory/Relax/tree/master/source/jvm_static_java_field.md)
8. [kotlin 编码规范](https://www.kotlincn.net/docs/reference/coding-conventions.html)
9. [kotlin in out区别与使用](https://github.com/UCodeUStory/Relax/tree/master/source/in_out.md)
10. kotlin 只有一个参数的函数，可以考虑使用中缀函数

        //中缀函数
        infix fun String.getChar(position: Int) = this.get(position)
        val s = "Hello world"
        val c = s getChar 1

11. kotlin 顶层函数和属性

    Java中本着”万物皆为对象“的设计原理，所有的函数和属性都是依附于class来实现的，因此很多独立的工具方法我们不得不为其创建一个类来进行管理，也就是我们常说的工具类。这样的实现其实是有些奇怪的，但是在Kotlin编程里为我们解决了这样的烦恼。

    我们可以在任何一个普通的.kt文件中声明我们想要的函数

        package com.example.xxx.kotlinapplication

        fun log(message: String?) {
            Log.i("TAG", message)
        }

    **kotlin 最终编译成Java时，也是和Java一样的套路**

        package com.example.xxx.kotlinapplication

        public class XXX() {
            public static void log(String message) {Log.i("TAG", message)}
        }

12. [局部拓展函数]

    评价一段代码的优劣最直接的方法就是看它有没有重复的代码。但是在我们正常编码中，经常会在一个小功能中遇到重复的小片段代码，如果将这段代码封装成方法会则会使得整个项目（类）变得臃肿，
    降低了代码的阅读性和精简性。在Kotlin中可以有更优雅的解决方案，就是局部拓展函数

        val User(name:String,address:String)
        fun (user:User){
            if(user.name.isEmpty){user.name = "匿名"}
            if(user.address.isEmpty){user.address = "未知"}
        }

        //使用局部拓展函数
        val User(name:String,address:String)
        fun (user:User){
            //减少代码重复，而不失作用域
            fun validate(value:String,hint:String){
               if(value.isEmpty){value = hint}
            }
            validate(user.name,"匿名")
            validate(user.address,"未知")
        }

13. [kotlin 默认值函数可以减少方法重载]


14. [kotlin 解构] 解构指的是，在赋值过程中，直接将一个对象的多个属性，赋值到多个变量上

            componentN  是操作符，所以需要重写，

            val (name, age) = cat
            val (name2, age2,color2) = cat

            Log.i("info", "name=$name,age=$age")
            Log.i("info", "name=$name2,age=$age2,color=$color2")

            class Cat(var name: String, var age: Int, var color: String) {

                operator fun component1(): String {
                    return name
                }

                operator fun component2(): Int {
                    return age
                }

                operator fun component3(): String {
                    return color
                }

            }