package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.BeanFactory;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/1/4
 */
public interface AutowireCapableBeanFactory extends BeanFactory {
  /**
   * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
   *
   * @param existingBean 现有的bean
   * @param beanName bean的名字
   * @return {@code Object}
   * @throws BeansException 异常
   */
  Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
      throws BeansException;

  /**
   * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
   *
   * @param existingBean 现有的bean
   * @param beanName bean的名字
   * @return {@code Object}
   * @throws BeansException 异常
   */
  Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
      throws BeansException;
}
