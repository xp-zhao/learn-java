package bean;

import org.junit.Test;

import org.smallspring.BeanDefinition;
import org.smallspring.BeanFactory;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:21 下午 */
public class SmallSpringTest {
  @Test
  public void testBeanFactory() {
    BeanFactory beanFactory = new BeanFactory();

    BeanDefinition beanDefinition = new BeanDefinition(new UserService());
    beanFactory.registerBeanDefinition("userService", beanDefinition);

    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }
}
