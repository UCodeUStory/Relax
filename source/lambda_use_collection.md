### lambda 表达式在集合中用法


1. val people = listOf<Person>(Person("aaa",123))
    //查找最大的一个
    people.maxBy {
        it.age
    }

2. 上面是简化写法，标准写法是这样的

    people.maxBy({
       p:Person -> p.age
    })

3. lambda表达式为函数调用的最后一个参数可以放在外边

    people.maxBy(){
        p:Person -> p.age
    }

4. lambda表达式为唯一参数可以省略 （）

    people.maxBy{
        p:Person -> p.age
    }

5. lambda表达式可以推到出参数类型可以省略参数类型
    people.maxBy{
        p -> p.age
    }

6. 如果当前上下文期望的是只有一个参数的lambda且这个参数的类型可以推断出来，就会生成it的名称代替
 people.maxBy {
        it.age
   }


7. 如果你想要当作参数传递的代码已经被定义成了函数，该怎么办，当然还可以传入一个这个函数的lambda，但有更方便的写法
  Kotlin和Java8一样，如果把函数转化一个值你就可以传递它。使用：：转化

  val getAge = Person::age //这种是成员引用

  // 例子
  Person p = Person("Test",213)
  int age = getAge(p)  //通过引用调用

8. people.maxBy(Person::age)  //等价上面所有 it.age

  val createPerson = ::Person 引用构造方法

  createPerson("hello",123) //通过引用调用

9. Kotlin 1.1以后可以使用绑定成员应用，就是用对象引用

   Person p = Person("Test",213)

   val getAge = p::age

### 集合中的应用

比如filter 是根据条件过滤掉数据，map会对每个元素应用给定函数并收集到一个集合中，作为数据变换

val people = listOf(Person("one",123），Person("two",456))

people.map{ it.name} //就会返回name的集合

漂亮写法 people.map(Person::name)






