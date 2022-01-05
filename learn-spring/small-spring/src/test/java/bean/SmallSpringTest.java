package bean;

import org.junit.Test;
import org.smallspring.beans.PropertyValue;
import org.smallspring.beans.PropertyValues;
import org.smallspring.beans.factory.config.BeanDefinition;
import org.smallspring.beans.factory.config.BeanReference;
import org.smallspring.beans.factory.supprot.CglibSubclassingInstantiationStrategy;
import org.smallspring.beans.factory.supprot.DefaultListableBeanFactory;
import org.smallspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.smallspring.context.support.ClassPathXmlApplicationContext;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:21 下午 */
public class SmallSpringTest {

  @Test
  public void testBeanFactory() {
    // 1. 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.setInstantiationStrategy(new CglibSubclassingInstantiationStrategy());
    // 2. UserDao 注册
    beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
    // 3. UserService 设置属性
    PropertyValues propertyValues = new PropertyValues();
    propertyValues.addPropertyValue(new PropertyValue("id", "10001"));
    propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
    // 4. UserService 注入 bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 5. UserService 获取 bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }

  @Test
  public void testNoApplicationContext() {
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // 2. 读取配置文件&注册Bean
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    reader.loadBeanDefinitions("classpath:spring.xml");

    // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
    MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
    beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

    // 4. Bean实例化之后，修改 Bean 属性信息
    MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
    beanFactory.addBeanPostProcessor(beanPostProcessor);

    // 5. 获取Bean对象调用方法
    UserService userService = beanFactory.getBean("userService", UserService.class);
    userService.queryUserInfo();
  }

  @Test
  public void testApplicationContext() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");

    // 2. 获取Bean对象调用方法
    UserService userService = applicationContext.getBean("userService", UserService.class);
    userService.queryUserInfo();
  }

  @Test
  public void test_xml() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    applicationContext.registerShutdownHook();

    // 2. 获取Bean对象调用方法
    UserService userService = applicationContext.getBean("userService", UserService.class);
    String result = userService.queryUserInfo();
    System.out.println("测试结果：" + result);
  }

  @Test
  public void testAware() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:spring.xml");
    applicationContext.registerShutdownHook();

    // 2. 获取Bean对象调用方法
    UserService userService = applicationContext.getBean("userService", UserService.class);
    String result = userService.queryUserInfo();
    System.out.println("测试结果：" + result);
    System.out.println("ApplicationContextAware：" + userService.getApplicationContext());
    System.out.println("BeanFactoryAware：" + userService.getBeanFactory());
  }
}
