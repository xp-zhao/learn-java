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

## tag: tiny-spring-0.0.3

增加对有构造函数的类进行实例化的功能

InstantiationStrategy: 对象实例化策略接口

SimpleInstantiationStrategy: jdk 实例化策略

CglibSubclassingInstantiationStrategy: cglib 实例化策略

## tag: tiny-spring-0.0.4

增加对象属性设置, 在对象实例化完成之后进行属性设置

PropertyValue: 类属性对象

PropertyValues: 类属性集合

BeanReference: 类引用对象

## tag: tiny-spring-0.0.5

从xml中解析, 注册 bean 对象

Resource: 资源加载接口

ClassPathResource: 从 classpath 中加载资源实现

FileSystemResource: 从文件系统中加载资源实现

UrlResource: 从网络 url 中加载资源实现

ResourceLoader: 资源获取接口

DefaultResourceLoader: 资源获取默认实现

BeanDefinitionReader: bean 定义信息读取接口

AbstractBeanDefinitionReader: bean 定义信息读取接口抽象类实现

XmlBeanDefinitionReader: 解析 xml 获取并注册 bean 定义