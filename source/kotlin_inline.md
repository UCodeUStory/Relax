
### 学习kotlin with run apply also let

我们把他们定义拆开来分析

比如本身方法，我们叫前方法，
后面传入的lambda，我们叫后方法，
而几个方法中主要和扩展和传入参数有关

1. with


    //前不扩展，前传入receiver，后扩展receiver，后不传入参数，返回值R(也就是函数返回值)

    public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        return receiver.block()
    }


    此函数作用就是可以节省很多中间变量的创建，比如多次访问一个对象的属性和方法，你不在需要写对象.方法，而是直接调用方法

    并且with函数提供返回值，返回值是最后一行

1. run
    //前不扩展，后不扩展，后不传入参数，返回值R(也就是函数返回值)
    //运行传入的函数，返回值是传入函数的返回值

        public inline fun <R> run(block: () -> R): R {
            contract {
                callsInPlace(block, InvocationKind.EXACTLY_ONCE)
            }
            return block()
        }
    //前扩展，后扩展，后不传入参数，返回值R(也就是函数返回值)
    //某对象上扩展一个函数,返回值是这个函数的最后一行，和with的区别就是一个是扩展对象上，一个是通过传入对象参数的方式，
    //写法不一样，但都可以达到相同的需求

        public inline fun <T, R> T.run(block: T.() -> R): R {
            contract {
                callsInPlace(block, InvocationKind.EXACTLY_ONCE)
            }
            return block()
        }

2. apply

    //前扩展，后扩展，返回值T(调用者本身)
    //可以看出返回值是调用者本身，语法实现，其他run 的第二种写法一样，可以用来实现build模式

        public inline fun <T> T.apply(block: T.() -> Unit): T {
            contract {
                callsInPlace(block, InvocationKind.EXACTLY_ONCE)
            }
            block()
            return this
        }

3. also

    //前扩展，后不扩展，后传入参数，返回值T(调用者本身)
    //与上面apply 的差别是传入的方法并没有扩展都调用者身上，而是通过传入参数的形式

       public inline fun <T> T.also(block: (T) -> Unit): T {
           contract {
               callsInPlace(block, InvocationKind.EXACTLY_ONCE)
           }
           block(this)
           return this
       }
4. let
    //前扩展，后不扩展，后传入参数，返回值R(也就是函数返回值)

        public inline fun <T, R> T.let(block: (T) -> R): R {
            contract {
                callsInPlace(block, InvocationKind.EXACTLY_ONCE)
            }
            return block(this)
        }

总结：扩赞函数不能直接调用，由对象调用；扩展函数可以访问对象内的成员和方法

with 这种本身没有扩展到调用者身上，所以，内部要调用扩展方法，就要传入一个receiver

apply 扩展到调用者身上，所以内部可以直接调用扩展方法
