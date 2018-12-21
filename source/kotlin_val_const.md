### val 、const 、object、 companion object 区别


#### object

1. object 可以修饰类，表示声明这个类的成员和方法都是静态的

2. object 修饰表达式，也就是创建匿名对象

#### companion object

1. 伴生对象，在一个类中存在，里面存放的变量和方法被修饰成静态的

#### val
1. 修饰常量，前面只能加private,kotlin编译成Java时会生成get和set方法
类似java中 private final

#### const
1. 必须修饰val，前面必须是public
等价于java中的
public final

#### 如果被companion object 修饰，const和val都可以用private和public



