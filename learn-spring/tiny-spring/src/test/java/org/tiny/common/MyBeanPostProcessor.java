package org.tiny.common;

import org.tiny.bean.UserService;
import org.tiny.beans.BeansException;
import org.tiny.beans.factory.config.BeanPostProcessor;

/** @author zhaoxiaoping @Description: @Date 2021-8-24 */
public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if ("userService".equals(beanName)) {
      UserService userService = (UserService) bean;
      userService.setLocation("location 修改");
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
}
