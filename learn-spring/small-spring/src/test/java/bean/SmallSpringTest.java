package bean;

import org.junit.Test;
import org.smallspring.beans.factory.config.BeanDefinition;
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
    // 2. 注册 bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    UserService userService1 = (UserService) beanFactory.getBean("userService", "xp");
    userService1.queryUserInfo();
    UserService userService2 = (UserService) beanFactory.getBean("userService", "xp");
    userService2.queryUserInfo();
    assert userService1 == userService2;
  }
}
