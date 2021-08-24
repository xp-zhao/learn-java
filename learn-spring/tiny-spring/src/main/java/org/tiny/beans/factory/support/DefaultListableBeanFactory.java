package org.tiny.beans.factory.support;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.tiny.beans.BeansException;
import org.tiny.beans.factory.ConfigurableListableBeanFactory;
import org.tiny.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: 可用的 BeanFactory 默认实现 @Date 2021-8-19 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
    implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

  /** 存储 BeanDefinition 对象 */
  private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

  @Override
  public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
    BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
    if (beanDefinition == null) {
      throw new BeansException("No bean named '" + beanName + "' is defined");
    }
    return beanDefinition;
  }

  @Override
  public void preInstantiateSingletons() throws BeansException {
    beanDefinitionMap.keySet().forEach(this::getBean);
  }

  @Override
  public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(beanName, beanDefinition);
  }

  @Override
  public boolean containsBeanDefinition(String beanName) {
    return beanDefinitionMap.containsKey(beanName);
  }

  @Override
  public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
    Map<String, T> result = new HashMap<>();
    beanDefinitionMap.forEach(
        (beanName, beanDefinition) -> {
          Class<?> beanClass = beanDefinition.getBeanClass();
          if (type.isAssignableFrom(beanClass)) {
            result.put(beanName, (T) getBean(beanName));
          }
        });
    return result;
  }

  @Override
  public String[] getBeanDefinitionNames() {
    return beanDefinitionMap.keySet().toArray(new String[0]);
  }
}
