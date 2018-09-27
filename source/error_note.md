



1. manifest.srcFile 中m是小写的，否则会报如下错误


    No signature of method: static org.gradle.api.java.archives.Manifest.srcFile() is applicable for argument types: (java.lang.String) values: [src/debug/AndroidManifest.xml]

2. 当项目中引入不到资源的时候，而且反复检查akotlin-android-extensions 依赖的都正确，
这个时候需要多make几次项目，具体原因我也不清楚，可能是kotlin一个bug吧

3. 每个模块切换项目类型时，先clean ， 再build 否者会报如下错误

    Execution failed for task ':module-business-two:transformClassesWithMultidexlistForDebug'.
    > com.android.build.api.transform.TransformException: Error while generating the main dex list.

4. Java 迁移 kotlin时会经常遇到 nullPointer 尤其是Dialog的onCreate中onSaveInstance变量很容易就空，要添加'？'处理

5. 当Java 的RecyclerAdapter转Kotlin时会遇到很多错误，其中我们要把ViewHolder 前面" internal inner "去掉

6. 插件化开发，注意插件的包名要和Iplugin所在的目录一致，例如：com.ustory.relax_business_component.plugin.inter，后期会优化这个包名让其变得尽量短一些

