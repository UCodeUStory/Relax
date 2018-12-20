

对于 Kotlin 1.3，可以使用注解 @JvmStatic 与 @JvmField 标记接口的 companion 对象成员。

1. 目的是什么？？

public class TestStatic {
    private int otherField = 0;

    public static final BigInteger BIG_INTEGER = BigInteger.ONE;

    public static void method() {
        System.out.println("call method");
    }
}

转kotlin

class TestStatic {
    private val otherField = 0

    companion object {
        val BIG_INTEGER = BigInteger.ONE

        fun method() {
            println("call method")
        }
    }
}

对于Java访问Java静态方法，直接类名.方法即可

但是，Java访问kotlin则需要 TestStatic.Companion.method();

为此使用 @JvmStatic 标记方法与 @JvmField 标记方法，就可以实现 类名.方法的调用方式

### 所以对于kotlin调用kotlin没有影响

### 对于Java调用Kotlin 起到优化，调用一直

