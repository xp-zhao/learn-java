package org.tiny.beans.factory.support;

import java.lang.reflect.Constructor;
import org.tiny.beans.BeansException;
import org.tiny.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: 对象实例化策略接口 @Date 2021-8-20 */
public interface InstantiationStrategy {

  /**
   * 对象实例化
   *
   * @param beanDefinition bean 定义对象
   * @param beanName bean 名称
   * @param ctor 对象构造函数对象
   * @param args 对象构造参数
   * @return 对象实例
   * @throws BeansException 实例化失败时抛出
   */
  Object instantiate(
      BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args)
      throws BeansException;
}
