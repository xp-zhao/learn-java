package org.smallspring.beans.factory.supprot;

import java.util.HashMap;
import java.util.Map;
import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.BeanDefinition;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-9
 **/
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements
    BeanDefinitionRegistry {

  private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

  @Override
  public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(beanName, beanDefinition);
  }

  @Override
  protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
    BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
    if (beanDefinition == null) {
      throw new BeansException("No bean named '" + beanName + "' is defined");
    }
    return beanDefinition;
  }
}
