package org.tiny.beans.factory.supprot;

import org.tiny.beans.BeansException;
import org.tiny.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: 抽象 BeanFactory 子类, 实现创建 bean 的方法 @Date 2021-8-19 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

  @Override
  protected Object createBean(String beanName, BeanDefinition beanDefinition)
      throws BeansException {
    Object bean;
    try {
      // 实例化 bean
      bean = beanDefinition.getBeanClass().newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new BeansException("实例化 bean 失败", e);
    }
    // 注册单例对象
    addSingleton(beanName, bean);
    return bean;
  }
}
