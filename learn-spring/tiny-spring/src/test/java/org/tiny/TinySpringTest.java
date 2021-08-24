package org.tiny;

import org.junit.Test;
import org.tiny.bean.UserDao;
import org.tiny.bean.UserService;
import org.tiny.beans.PropertyValue;
import org.tiny.beans.PropertyValues;
import org.tiny.beans.factory.config.BeanDefinition;
import org.tiny.beans.factory.config.BeanReference;
import org.tiny.beans.factory.support.DefaultListableBeanFactory;
import org.tiny.beans.factory.xml.XmlBeanDefinitionReader;
import org.tiny.common.MyBeanFactoryPostProcessor;
import org.tiny.common.MyBeanPostProcessor;
import org.tiny.context.support.ClassPathXmlApplicationContext;

/** @author zhaoxiaoping @Description: 测试用例 @Date 2021-8-19 */
public class TinySpringTest {
  @Test
  public void testBeanFactory() {
    // 1. 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 2. 注册 UserDao
    beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
    // 3. 设置 UserService 属性
    PropertyValues propertyValues = new PropertyValues();
    propertyValues.addPropertyValue(new PropertyValue("id", "10002"));
    propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
    // 3. 注册 UserService
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 4. 获取 bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    System.out.println(userService.queryUserInfo());
  }

  @Test
  public void testXmlBeanDefinition() {
    // 1. 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 2. 读取配置文件&注册Bean
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    reader.loadBeanDefinitions("classpath:spring.xml");
    // 3. 获取Bean对象调用方法
    UserService userService = beanFactory.getBean("userService", UserService.class);
    System.out.println(userService.queryUserInfo());
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
    String result = userService.queryUserInfo();
    System.out.println("测试结果：" + result);
  }

  @Test
  public void testApplicationContext() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext =
        new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

    // 2. 获取Bean对象调用方法
    UserService userService = applicationContext.getBean("userService", UserService.class);
    String result = userService.queryUserInfo();
    System.out.println("测试结果：" + result);
  }
}
