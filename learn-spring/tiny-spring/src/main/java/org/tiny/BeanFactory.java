package org.tiny;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** @author zhaoxiaoping @Description: bean 对象工厂 @Date 2021-8-19 */
public class BeanFactory {

  /** 底层存放 BeanDefinition 的容器 */
  private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

  /**
   * 注册 BeanDefinition
   *
   * @param beanName 名称
   * @param beanDefinition 对象
   */
  public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(beanName, beanDefinition);
  }

  /**
   * 通过名称获取对象
   *
   * @param name bean 名称
   * @return bean 对象
   */
  public Object getBean(String name) {
    return beanDefinitionMap.get(name).getBean();
  }
}
