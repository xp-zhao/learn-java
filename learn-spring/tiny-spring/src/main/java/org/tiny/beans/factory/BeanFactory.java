package org.tiny.beans.factory;

import org.tiny.beans.BeansException;

/** @author zhaoxiaoping @Description: bean 对象工厂 @Date 2021-8-19 */
public interface BeanFactory {

  /**
   * 通过名称获取对象
   *
   * @param name bean 名称
   * @return bean 对象
   * @throws BeansException 获取不到bean时抛出
   */
  Object getBean(String name) throws BeansException;

  /**
   * 通过名称和参数获取对象
   *
   * @param name bean 名称
   * @param args 构造参数
   * @return bean 对象
   * @throws BeansException 获取不到 bean 时抛出
   */
  Object getBean(String name, Object... args) throws BeansException;

  /**
   * 通过类型获取对象
   *
   * @param name bean 名称
   * @param requiredType 类型
   * @param <T> 对象泛型
   * @return 对象
   * @throws BeansException 异常
   */
  <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
