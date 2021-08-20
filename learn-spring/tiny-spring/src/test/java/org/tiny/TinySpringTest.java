package org.tiny;

import org.junit.Test;
import org.tiny.bean.UserDao;
import org.tiny.bean.UserService;
import org.tiny.beans.PropertyValue;
import org.tiny.beans.PropertyValues;
import org.tiny.beans.factory.config.BeanDefinition;
import org.tiny.beans.factory.config.BeanReference;
import org.tiny.beans.factory.support.DefaultListableBeanFactory;

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
    userService.queryUserInfo();
  }
}
