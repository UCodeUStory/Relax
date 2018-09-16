### 惰性集合操作


当我们对一个集合执行.map.filter 链式调用时，每一步都会产生一个临时列表，减低效率

通过序列可以解决这个问题

使用方法，集合.asSequence()就是将一个结合转成序列，再通过toList()转回集合，为什么要转回去呢？因为序列中并没有集合的相关API，

只有map filter 等API

peoples.asSequence().map(Person:name).filter(it.startWiths("A").toList()