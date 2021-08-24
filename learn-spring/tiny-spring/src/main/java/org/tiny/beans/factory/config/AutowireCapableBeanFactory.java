package org.tiny.beans.factory.config;

import org.tiny.beans.BeansException;
import org.tiny.beans.factory.BeanFactory;

/** @author zhaoxiaoping @Description: 可自动装配的 Bean 工厂 @Date 2021-8-24 */
public interface AutowireCapableBeanFactory extends BeanFactory {

  /**
   * 执行 {@link BeanPostProcessor} 接口实现类的 postProcessBeforeInitialization 方法
   *
   * @param existingBean 现有的 bean
   * @param beanName bean 名称
   * @return 修改后的 bean
   * @throws BeansException 异常
   */
  Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
      throws BeansException;

  /**
   * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
   *
   * @param existingBean 现有的 bean
   * @param beanName bean 名称
   * @return 修改后的 bean
   * @throws BeansException 异常
   */
  Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
      throws BeansException;
}
