package org.learn.spring.beans.factory;

import org.junit.Test;
import org.learn.spring.beans.factory.bean.UserService;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {
  @Test
  public void testBeanFactory() {
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 2.注册 bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 3.第一次获取 bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
    // 4.第二次获取 bean from Singleton
    UserService userService1 = (UserService) beanFactory.getBean("userService");
    userService1.queryUserInfo();
    System.out.println(userService == userService1);
  }
}
