package org.learn.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * bean 对象工厂
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class BeanFactory {
  /** 存放 bean 定义到 Map 中 */
  private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

  public Object getBean(String name) {
    return beanDefinitionMap.get(name).getBean();
  }

  public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(name, beanDefinition);
  }
}
