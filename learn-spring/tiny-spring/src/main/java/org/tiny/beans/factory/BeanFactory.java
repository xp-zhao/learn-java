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
}
