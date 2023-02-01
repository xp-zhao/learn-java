package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认单例注册接口实现
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

  private Map<String, Object> singletonObjects = new HashMap<>();

  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  /**
   * 注册单例对象
   *
   * @param beanName
   * @param singletonObject
   */
  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }
}
