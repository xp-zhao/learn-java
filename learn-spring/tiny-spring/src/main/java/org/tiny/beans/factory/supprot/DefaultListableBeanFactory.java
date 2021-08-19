package org.tiny.beans.factory.supprot;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.tiny.beans.BeansException;
import org.tiny.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: 可用的 BeanFactory 默认实现 @Date 2021-8-19 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
    implements BeanDefinitionRegistry {

  /** 存储 BeanDefinition 对象 */
  private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

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
}
