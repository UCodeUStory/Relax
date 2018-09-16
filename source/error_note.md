



1. manifest.srcFile 中m是小写的，否则会报如下错误


    No signature of method: static org.gradle.api.java.archives.Manifest.srcFile() is applicable for argument types: (java.lang.String) values: [src/debug/AndroidManifest.xml]

2. 当项目中引入不到资源的时候，而且反复检查akotlin-android-extensions 依赖的都正确，
这个时候需要多make几次项目，具体原因我也不清楚，可能是kotlin一个bug吧

3. 每个模块切换项目类型时，先clean ， 再build 否者会报如下错误

    Execution failed for task ':module-business-two:transformClassesWithMultidexlistForDebug'.
    > com.android.build.api.transform.TransformException: Error while generating the main dex list.