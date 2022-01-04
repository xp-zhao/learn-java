package org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;

/**
 * Bean 工厂接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public interface BeanFactory {
  /**
   * 通过 Bean 名称获取 Bean 对象
   *
   * @param beanName bean的名字
   * @return {@code Object}
   * @throws BeansException 异常
   */
  Object getBean(String beanName) throws BeansException;
}
