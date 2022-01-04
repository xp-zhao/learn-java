package org.learn.spring.beans.factory;

import cn.hutool.core.io.IoUtil;
import org.junit.Before;
import org.junit.Test;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.bean.UserDao;
import org.learn.spring.beans.factory.bean.UserService;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanReference;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;
import org.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;
import org.learn.spring.core.io.DefaultResourceLoader;
import org.learn.spring.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {
  @Test
  public void testBeanFactory() {
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // 2. UserDao 注册
    beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

    // 3. UserService 设置属性[uId、userDao]
    PropertyValues propertyValues = new PropertyValues();
    propertyValues.addPropertyValue(new PropertyValue("uId", "10002"));
    propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

    // 4. UserService 注入bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
    beanFactory.registerBeanDefinition("userService", beanDefinition);

    // 5. UserService 获取bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    String result = userService.queryUserInfo();
    System.out.println("测试结果：" + result);
  }

  private DefaultResourceLoader resourceLoader;

  @Before
  public void init() {
    resourceLoader = new DefaultResourceLoader();
  }

  @Test
  public void test_classpath() throws IOException {
    Resource resource = resourceLoader.getResource("classpath:important.properties");
    InputStream inputStream = resource.getInputStream();
    String content = IoUtil.readUtf8(inputStream);
    System.out.println(content);
  }

  @Test
  public void test_xml() {
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

    // 2. 读取配置文件&注册Bean
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
    reader.loadBeanDefinitions("classpath:spring.xml");

    // 3. 获取Bean对象调用方法
    UserService userService = beanFactory.getBean("userService", UserService.class);
    String result = userService.queryUserInfo();
    System.out.println("测试结果：" + result);
  }
}
