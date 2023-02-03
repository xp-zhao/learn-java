package org.learn.spring.v6.common;

import org.learn.spring.v6.bean.UserService;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-3
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if ("userService".equals(beanName)) {
      UserService userService = (UserService) bean;
      userService.setName("name 修改");
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
}
