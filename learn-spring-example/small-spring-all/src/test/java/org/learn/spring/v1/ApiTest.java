package org.learn.spring.v1;

import org.junit.Test;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;
import org.learn.spring.v1.bean.UserService;

/**
 * 单元测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class ApiTest {
  @Test
  public void testBeanFactory() {
    // 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 注册 Bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 获取 Bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }
}
