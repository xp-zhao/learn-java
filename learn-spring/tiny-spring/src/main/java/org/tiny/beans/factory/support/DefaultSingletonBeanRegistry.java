package org.tiny.beans.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.tiny.beans.factory.config.SingletonBeanRegistry;

/** @author zhaoxiaoping @Description: 单例对象注册接口默认实现 @Date 2021-8-19 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

  /** 存储单例对象 */
  private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

  /**
   * 通过 bean 名称获取单例对象
   *
   * @param beanName bean名称
   * @return 单例对象
   */
  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  /**
   * 注册单例对象
   *
   * @param beanName bean 名称
   * @param singletonObject 单例对象
   */
  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }
}
