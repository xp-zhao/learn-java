package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanFactory 核心实现类, 负责注册,获取 BeanDefinition
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
    implements BeanDefinitionRegistry {

  private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

  @Override
  protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
    BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
    if (beanDefinition == null) {
      throw new BeansException("No bean named '" + beanName + "' is defined");
    }
    return beanDefinition;
  }

  @Override
  public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(beanName, beanDefinition);
  }

  @Override
  public boolean containsBeanDefinition(String beanName) {
    return beanDefinitionMap.containsKey(beanName);
  }
}
