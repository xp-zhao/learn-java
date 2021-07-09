package org.smallspring.beans.factory.supprot;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.BeanDefinition;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-9
 **/
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition)
      throws BeansException {
    Object bean = null;
    try {
      bean = beanDefinition.getBeanClass().newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new BeansException("初始化 bean 失败", e);
    }
    // 注册单例对象
    addSingleton(beanName, bean);
    return bean;
  }
}
