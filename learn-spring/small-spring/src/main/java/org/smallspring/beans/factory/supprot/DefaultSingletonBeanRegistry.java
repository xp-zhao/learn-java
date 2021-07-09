package org.smallspring.beans.factory.supprot;

import java.util.HashMap;
import java.util.Map;
import org.smallspring.beans.factory.config.SingletonBeanRegistry;

/**
 * @Author: xp-zhao
 * @Description: TODO
 * @DateTime: 2021/7/8 11:36 下午
 **/
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

  private Map<String, Object> singletonObjects = new HashMap<>();

  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }
}
