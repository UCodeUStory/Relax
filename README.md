
<div align="center">
<img width="810" height="180" src="https://github.com/UCodeUStory/Relax/blob/master/source/relax.png"/>
</div>

<div align="center">

![Language](https://img.shields.io/badge/language-Kotlin-EE0000.svg)
![](https://img.shields.io/badge/QQ-1483888222-green.svg)
![SDK](https://img.shields.io/badge/SDK-14%2B-orange.svg)
[![License](https://img.shields.io/apm/l/vim-mode.svg)](https://github.com/UCodeUStory/Relax/tree/master/LICENSE)

</div>


Relax 基于Kotlin语言编写的一套组件化框架，内部可以实现灵活的配置

Relax is a android frame by Component Frame

### 语言
[Kotlin 学习笔记、里面是我踩过的各种坑(>_<) ](https://github.com/UCodeUStory/Relax/tree/master/source/kotlin.md)


<div align="center">

<img width="180" height="320" src="https://github.com/UCodeUStory/Relax/blob/master/source/tianqi.jpg"/>
<img width="180" height="320" src="https://github.com/UCodeUStory/Relax/blob/master/source/meitu.jpg"/>
<img width="180" height="320" src="https://github.com/UCodeUStory/Relax/blob/master/source/xinwen.jpg"/>

</div>


### 架构模式

#### 1. module

      业务层，分解成独立的模块

      module-business-news   module-business-weather   module-business-welfare   module-business-four

      每个模块内部可以实现插件化跟细粒度小功能

#### 2. relax-business-component

      基础业务层和可变的第三方业务(比如地图封装、IM封装、日志上传封装、友盟统计封装、Bugly封装，这些业务我们
      情景1：可能实现方式会变(如图片加载之前用glide，现在想用Fresco,所以通过接口统一实现；
      情景2：有些业务可能在不同的App宿主中不需要，所以提供动态配置来减少安装包体积))
      所以针对第三方业务实现，通过分别实现不同的依赖库封装在BusinessFactory中，同时通过factoryinterface提供
      统一接口

#### 3. relax-data-component

      数据层，提供业务数据，包含网络数据、本地数据，SP数据

#### 4. relax-core-component

      基础组件层, 一些框架必须要用的library、核心的架构实现、如mvvm、mvp基础架构、自定义UI组件等

#### 5. relax-dependents

      公共依赖集合，提供统一配置

#### 统一配置gradle.properties

    ### 库和应用两种模式间切换
    ### 只有app 为false 其他模块才可以设置true
    relaxBusinessPlugin_isApp = false
    relaxBusinessNews_isApp = false
    relaxBusinessWeather_isApp = true
    relaxBusinessWelfare_isApp = false
    relaxBusinessComponent_isApp= false
    ### 启用检查代码 启用会牺牲打包时间
    isCheckCode = false
    ### 动态配置减少打包体积
    glideEnable = true
    picassoEnable = false
    isMVVM = true
    isMVP = false
    isApp = false


### 架构图

<div align="center">

<img width="1050" height="800" src="https://github.com/UCodeUStory/Relax/blob/master/source/new_frame.png"/>

</div>



### 项目内容

#### 1. 实现组件化，可以分层调试，单独模块调试；
#### 2. 支持 checkstyle,pmd,findBugs对代码静态扫描，虽然目前只支持Java检查，但开发过程中还是会用到一些Java代码和xml的检查；
#### 3. basic-component层 添加MVVM架构支持；
#### 4. basic-component层，添加MVP架构支持；
#### 5. 根据配置动态选择打包架构；
#### 6. 封装kotlin版本的权限检查，使用更简单；
#### 7. 将Application放到business-component层，因为我们要在这一层做基础业务组件开发，会全局初始化一些组件；
#### 8. 封装data层接口，对外通过DataServiceManager提供统一接口(LocalDataService和NetDataService)，在Service

      内部我们可以通过Retrofit、OkHttp、Volley等来实现网络请求,(项目核心使用rxjava来完成数据流，如果用其他网络框架，也尽量返回Observable,来保证封装一致性)

#### 9. 封装图片加载框架，通过ImageEngine对外提供加载图片引擎，通过ILoader对底层提供实现接口
#### 10. 封装插件化框架通过PluginManager进行管理插件

      例子：module-business-plugin模块就是用插件化实现的，具体插件式项目中的RelaxPluginDemo



Libraries Used
--------------

  * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
  * [LiveData][13] - Build data objects that notify views when the underlying database changes.
  * [Navigation][14] - Handle everything needed for in-app navigation.
  * [Room][16] - Access your app's SQLite database with in-app objects and compile-time checks.
  * [ViewModel][17] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
  * [WorkManager][18] - Manage your Android background jobs.
* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
  * [Animations & Transitions][31] - Move widgets and transition between screens.
  * [Fragment][34] - A basic unit of composable UI.
  * [Layout][35] - Lay out widgets using different algorithms.
* Third party
  * [Glide][90] for image loading
  * [Rxjava][91]  for Reactive Programming
  * [ARouter][92]   A framework for assisting in the renovation of Android app componentization
  * [Retrofit][93] A restful client
  * [EventBus][94] An Android event publish/subscribe lightweight framework
  * [Dagger][95] a fully static, compile-time dependency injection framework for both Java and Android.
  * [GSON][97] Tool class for converting Java objects to Json strings and Json strings to objects
  * [LeakCannary][99] Is the main tool for Android to find memory leaks.
  * [Aspect][100] optimize your contact center performance through improved customer service and efficiency.

[0]: https://developer.android.com/jetpack/foundation/
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[4]: https://developer.android.com/training/testing/
[10]: https://developer.android.com/jetpack/arch/
[11]: https://developer.android.com/topic/libraries/data-binding/
[12]: https://developer.android.com/topic/libraries/architecture/lifecycle
[13]: https://developer.android.com/topic/libraries/architecture/livedata
[14]: https://developer.android.com/topic/libraries/architecture/navigation/
[16]: https://developer.android.com/topic/libraries/architecture/room
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel
[18]: https://developer.android.com/topic/libraries/architecture/workmanager
[30]: https://developer.android.com/jetpack/ui/
[31]: https://developer.android.com/training/animation/
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout
[90]: https://bumptech.github.io/glide/
[91]: https://github.com/ReactiveX/RxJava
[92]: https://github.com/alibaba/ARouter
[93]: https://github.com/square/retrofit
[94]: http://greenrobot.org/eventbus/
[95]: https://google.github.io/dagger/android
[96]: https://github.com/square/okhttp
[97]: https://github.com/google/gson
[98]: https://github.com/bumptech/glide
[99]: https://github.com/square/leakcanary
[100]: http://mvnrepository.com/artifact/org.aspectj/aspectjtools


### 开发过程错误总结
- [错误日志](https://github.com/UCodeUStory/Relax/tree/master/source/error_note.md)







