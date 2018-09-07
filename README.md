# Relax
Relax is a android frame by Component MVVM model



1. module-business   module-business   module-business   module-business

2. relax-business-component   基本业务组件

3. relax-data-component   数据组件

4. relax-basic-component  基础框架组件

5. relax-dependents  公共依赖


#### 待实现
实现每一层都可以单独调试

分配不同的AndroidManifest  和测试用例

#### 
添加ARouter，组件跳转？ 传递数据？广播传递数据？

####

business -component 添加常用业务组件，如登录，注册，友盟统计（可配置，可以不使用，不编译，使用多个文件包）

####
basic 添加缓存，如LRU 或RXJava  (可配置，可移除),(图片加载等)
common组件是基础库，添加一些公用的类；
例如：网络请求、图片加载、工具类、base类等等；
声明APP需要的uses-permission；
定义全局通用的主题（Theme）；

#### 添加AOP插件

#### basic添加MVP 和 MVVM （可配置，可移除）

#### 编写自动打包脚本

#### 代码质量检测工具FindBugs、PMD和CheckStyle







