package org.learn.spring;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean 对象工厂 (注册, 获取 Bean 对象)
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class BeanFactory {
  /** 存放 BeanDefinition */
  private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

  public Object getBean(String beanName) {
    return beanDefinitionMap.get(beanName).getBean();
  }

  public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(name, beanDefinition);
  }
}
