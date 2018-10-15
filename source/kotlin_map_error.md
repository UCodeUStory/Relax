记录一个Kotlin中对map遍历foreach遇见的问题

kotlin开发Android,期间用到了对map进行键和值的遍历，代码大致如下：

    //创建了一个map
    val showFields = mapOf(
            "NAME_CHN" to "名称",
            "ADDR_CHN" to "地址",
            "YHDD" to "名称",
            "NAME" to "名称",
            "NAME_1" to "地址"
    )

遍历时的代码是

//直接用foreach，IDE自动补全了代码
showFields.forEach { key, value ->
                try {
                    //此部分对key、value进行操作
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

编译时没有问题，运行时在部分手机上出现问题，报错崩掉，log：

java.lang.NoClassDefFoundError: ... ...

showFields.forEach { key, value ->

这一行修改成

showFields.forEach { (key, value) ->

也就是将key和value用小括号括起来。
具体原因还不知道，而且还不是所有机器有问题，