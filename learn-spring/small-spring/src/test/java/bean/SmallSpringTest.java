package bean;

import org.junit.Test;
import org.smallspring.beans.PropertyValue;
import org.smallspring.beans.PropertyValues;
import org.smallspring.beans.factory.config.BeanDefinition;
import org.smallspring.beans.factory.config.BeanReference;
import org.smallspring.beans.factory.supprot.CglibSubclassingInstantiationStrategy;
import org.smallspring.beans.factory.supprot.DefaultListableBeanFactory;

/**
 * @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:21 下午
 */
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
    //5. UserService 获取 bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }
}
