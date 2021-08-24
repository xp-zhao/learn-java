package org.tiny.beans.factory.config;

import org.tiny.beans.BeansException;

/** @author zhaoxiaoping @Description: 实例化 Bean 对象修改接口 @Date 2021-8-24 */
public interface BeanPostProcessor {

  /**
   * 在 Bean 对象执行初始化方法之前, 执行此方法
   *
   * @param bean bean 对象
   * @param beanName bean 名称
   * @return 修改后的 bean 对象
   * @throws BeansException 异常
   */
  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

  /**
   * 在 Bean 对象执行初始化方法之后, 执行此方法
   *
   * @param bean bean 对象
   * @param beanName bean 名称
   * @return 修改后的 bean 对象
   * @throws BeansException 异常
   */
  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
