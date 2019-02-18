### in_out


#### 使用场景1

- 如果你的类是将泛型作为内部方法的返回，那么可以用 out：

        interface Production<out T> {
            fun produce(): T
        }

- 如果你的类是将泛型对象作为函数的参数，那么可以用 in：

        interface Consumer<in T> {
            fun consume(item: T)
        }

什么也不加，就既可以作为参数，也可以作为返回值

####

根据以上的内容，我们还可以这样来理解什么时候用 in 和 out：

父类泛型对象可以赋值给子类泛型对象，用 in；
子类泛型对象可以赋值给父类泛型对象，用 out。


一个泛型具有多个类型限制用 List<T> where T： Enum<T>, T: HasValue<T>