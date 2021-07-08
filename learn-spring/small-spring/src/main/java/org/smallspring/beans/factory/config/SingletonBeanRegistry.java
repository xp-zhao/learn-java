package org.smallspring.beans.factory.config;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/8 11:34 下午 */
public interface SingletonBeanRegistry {
  Object getSingleton(String beanName);
}
