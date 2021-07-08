package org.smallspring;

import org.smallspring.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:16 下午 */
public class BeanFactory {
  private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

  public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(beanName, beanDefinition);
  }

  public Object getBean(String name) {
    return beanDefinitionMap.get(name).getBean();
  }
}
