package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanDefinition 后置处理接口, 用于自定义修改 BeanDefinition 信息
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface BeanFactoryPostProcessor {

  /**
   * BeanDefinition 后置处理, 在所有的 BeanDefinition 加载完成之后, Bean 对象实例化之前执行
   *
   * @param beanFactory
   * @throws BeansException
   */
  void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
