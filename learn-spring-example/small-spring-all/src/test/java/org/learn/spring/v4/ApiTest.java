package org.learn.spring.v4;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanReference;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;
import org.learn.spring.v4.bean.UserDao;
import org.learn.spring.v4.bean.UserService;

/**
 * 单元测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
@Slf4j
public class ApiTest {
  @Test
  public void testBeanFactory() {
    // 初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 注册 UserDao
    beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
    // 设置 UserService 属性
    PropertyValues propertyValues = new PropertyValues();
    propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
    propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
    // 注册 UserService
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
    beanFactory.registerBeanDefinition("userService", beanDefinition);

    // 获取 Bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }
}
