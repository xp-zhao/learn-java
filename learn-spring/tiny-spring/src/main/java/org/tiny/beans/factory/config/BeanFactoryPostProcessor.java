package org.tiny.beans.factory.config;

import org.tiny.beans.BeansException;
import org.tiny.beans.factory.ConfigurableListableBeanFactory;

/** @author zhaoxiaoping @Description: 修改 BeanDefinition 属性信息接口 @Date 2021-8-24 */
public interface BeanFactoryPostProcessor {

  /**
   * 在所有的 BeanDefinition 加载完成之后, 实例化 Bean 对象之前, 提供修改 BeanDefinition 属性的方法
   *
   * @param beanFactory bean 工厂
   * @throws BeansException 异常
   */
  void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
