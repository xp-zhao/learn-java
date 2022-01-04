package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认单例接口实现
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

  private Map<String, Object> singletonObjects = new HashMap<>();

  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  /**
   * 添加单例对象
   *
   * @param beanName bean的名字
   * @param singletonObject 单例对象
   */
  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }
}
