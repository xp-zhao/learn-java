package org.learn.spring;

import org.junit.Test;
import org.learn.spring.bean.UserService;

public class ApiTest {

  @Test
  public void testBeanFactory() {
    // 1.初始化 BeanFactory
    BeanFactory beanFactory = new BeanFactory();
    // 2.注入bean
    BeanDefinition beanDefinition = new BeanDefinition(new UserService());
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 3.获取bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }
}
