package org.learn.spring.v1;

import org.junit.Test;
import org.learn.spring.BeanDefinition;
import org.learn.spring.BeanFactory;
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
    BeanFactory beanFactory = new BeanFactory();
    // 注册 Bean
    BeanDefinition beanDefinition = new BeanDefinition(new UserService());
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 获取 Bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }
}
