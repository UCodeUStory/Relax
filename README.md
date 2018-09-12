### Relax

Relax 基于Kotlin语言编写的一套组件化框架

Relax is a android frame by Component Frame

#### 架构模式


1. 业务层，各种模块 module-business-one   module-business-two   module-business-three   module-business-four

2. relax-business-component

      基础业务层，如地图封装、IM封装、日志上传封装、友盟统计封装、Bugly封装

3. relax-data-component

      数据层，提供业务数据，包含网络数据、本地数据，SP数据

4. relax-basic-component

      基础组件层, 一些框架必须要用的library、核心的架构实现、如mvvm、mvp基础架构、自定义UI组件等

5. relax-dependents

      公共依赖集合，提供统一配置


#### 项目内容
1. 实现组件化，可以分层调试，单独模块调试
2. 支持 checkstyle,pmd,findBugs对代码静态扫描，虽然目前只支持Java检查，但开发过程中还是会用到一些Java代码和xml的检查
3. basic-commpent层 添加MVVM支持
4. 根据配置动态选择打包MVP文件夹 或 MVVM文件夹


#### Library
1. Rxjava
2. Retrofit
3. LifeCycle
4. LiveData
5. ViewModel
6. ARouter
7. EventBus
8. Dagger





####
添加ARouter，组件跳转？ 传递数据？广播传递数据？

####

business -component 添加常用业务组件，如登录，注册，友盟统计（可配置，可以不使用，不编译，使用多个文件包）

####
basic 添加缓存，如LRU 或RXJava  (可配置，可移除),(图片加载等)
EventBus 添加选择性打包
common组件是基础库，添加一些公用的类；
例如：网络请求、图片加载、工具类、base类等等；
声明APP需要的uses-permission；
定义全局通用的主题（Theme）；

#### 添加AOP插件


#### 编写自动打包脚本 实现自动上传指定服务器








