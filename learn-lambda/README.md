# 常用函数式接口
函数接口 | 抽象方法 | 功能 | 参数 | 返回类型 | 示例
---|---|---|---|---|---
Predicate<T> | test(T t) | 判断真假 |  T | boolean | 这张唱片已经发行了吗
Consumer<T> | accept(T t) | 消费消息 |  T | void | 输出一个值
Function<T,R> | R accept(T t) | 将 T 映射为 R（转换功能） |  T | R | 获得 Artist 对象的名字
Supplier<T> | T get() | 生产消息 |  None | T | 工厂方法
UnaryOperator<T> | T apply(T t) | 一元操作 |  T | T | 逻辑非（!）
BinaryOperator<T> | apply(T t, U u)  | 二元操作 |  (T, T) | T | 求两个数的乘积（*）