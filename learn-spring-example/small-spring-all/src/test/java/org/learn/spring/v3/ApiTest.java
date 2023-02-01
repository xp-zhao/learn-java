package org.learn.spring.v3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;
import org.learn.spring.beans.factory.support.SimpleInstantiationStrategy;
import org.learn.spring.v3.bean.UserService;

/**
 * 单元测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
@Slf4j
public class ApiTest {
  @Test
  public void testDefaultInstantiation() {
    // 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 注册 Bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 获取 Bean
    UserService userService = (UserService) beanFactory.getBean("userService", "cglib 有参构造测试");
    userService.queryUserInfo();
  }

  @Test
  public void testDefaultInstantiationWithoutParams() {
    // 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 注册 Bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 获取 Bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }

  @Test
  public void testSimpleInstantiation() {
    // 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());
    // 注册 Bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 获取 Bean
    UserService userService = (UserService) beanFactory.getBean("userService", "simple 有参构造测试");
    userService.queryUserInfo();
  }

  @Test
  public void testSimpleInstantiationWithoutParams() {
    // 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    beanFactory.setInstantiationStrategy(new SimpleInstantiationStrategy());
    // 注册 Bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 获取 Bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }
}
