package org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;

import java.util.Map;

/**
 * BeanFactory 拓展接口, 提供拓展方法
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface ListableBeanFactory extends BeanFactory {
  /**
   * 通过类型获取 bean 对象
   *
   * @param type
   * @return
   * @param <T>
   * @throws BeansException
   */
  <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;
}
