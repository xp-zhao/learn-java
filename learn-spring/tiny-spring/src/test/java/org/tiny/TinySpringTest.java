package org.tiny;

import org.junit.Test;
import org.tiny.bean.UserService;

/** @author zhaoxiaoping @Description: 测试用例 @Date 2021-8-19 */
public class TinySpringTest {
  @Test
  public void testBeanFactory() {
    // 1. 初始化 BeanFactory
    BeanFactory beanFactory = new BeanFactory();
    // 2. 注册 bean
    BeanDefinition beanDefinition = new BeanDefinition(new UserService());
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 3. 获取 bean
    UserService userService = (UserService) beanFactory.getBean("userService");
    userService.queryUserInfo();
  }
}
