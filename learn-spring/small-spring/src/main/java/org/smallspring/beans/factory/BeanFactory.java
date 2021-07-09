package org.smallspring.beans.factory;

import org.smallspring.beans.BeansException;

/**
 * @Author: xp-zhao
 * @Description: TODO
 * @DateTime: 2021/7/8 11:33 下午
 **/
public interface BeanFactory {

  /**
   * 通过 bean 名称获取 bean 对象
   *
   * @param name bean名称
   * @return bean 对象
   * @throws BeansException 无法获取 bean 时抛出异常
   */
  Object getBean(String name) throws BeansException;
}
