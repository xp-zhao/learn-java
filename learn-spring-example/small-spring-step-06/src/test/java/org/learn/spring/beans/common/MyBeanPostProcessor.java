package org.learn.spring.beans.common;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.bean.UserService;
import org.learn.spring.beans.factory.config.BeanPostProcessor;

/**
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if ("userService".equals(beanName)) {
      UserService userService = (UserService) bean;
      userService.setName("修改 name");
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
}
