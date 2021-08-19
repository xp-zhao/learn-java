# tiny-spring
## tag: tiny-spring-0.0.1
BeanDefinition: 用于定义 bean 实例化信息, 通过一个 Object 来存放 bean 对象

BeanFactory: bean 对象工厂, 提供 bean 的注册和获取功能 (目前是将 bean 定义存放到 map 中)

## tag: tiny-spring-0.0.2
BeansException: 自定义 bean 异常 

BeanDefinition: 不再存放实例化的对象, 只存储对象的 Class 信息

BeanFactory: 提供获取 bean 对象的接口

BeanDefinitionRegistry: 提供 BeanDefinition 对象注册接口

SingletonBeanRegistry: 提供获取单例对象的接口

DefaultSingletonBeanRegistry: 单例对象获取接口默认实现类, 提供注册单例对象的方法

AbstractBeanFactory: 抽象工厂, 实现 BeanFactory 中的获取 bean 对象的接口, 封装统一的获取 bean 的逻辑(先获取单例对象, 若没有则重
新创建), 定义获取 BeanDefinition 和 创建对象的抽象方法

AbstractAutowireCapableBeanFactory: 抽象工厂子类, 实现创建 bean 对象的方法

DefaultListableBeanFactory: 默认可用的 BeanFactory, 实现注册, 获取 BeanDefinition 的方法

![tiny-spring-0.0.2](https://xp-note-oss.oss-cn-chengdu.aliyuncs.com/tiny-spring-0.0.2.png)

