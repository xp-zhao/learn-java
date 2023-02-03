package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.BeanFactory;

/**
 * BeanFactory 拓展接口, 负责执行 BeanPostProcessor 的方法
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
  /**
   * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
   *
   * @param existingBean
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
      throws BeansException;

  /**
   * 执行 BeanPostProcessors 接口实现类的 postProcessAfterInitialization 方法
   *
   * @param existingBean
   * @param beanName
   * @return
   * @throws BeansException
   */
  Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
      throws BeansException;
}
