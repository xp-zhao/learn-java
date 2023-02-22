package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FactoryBean 注册服务
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

  /** Cache of singleton objects created by FactoryBeans: FactoryBean name --> object */
  private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

  protected Object getCachedObjectForFactoryBean(String beanName) {
    Object obj = factoryBeanObjectCache.get(beanName);
    return (obj != NULL_OBJECT) ? obj : null;
  }

  protected Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName) {
    if (factoryBean.isSingleton()) {
      Object obj = this.factoryBeanObjectCache.get(beanName);
      if (obj == null) {
        obj = doGetObjectFromFactoryBean(factoryBean, beanName);
        this.factoryBeanObjectCache.put(beanName, (obj != null) ? obj : NULL_OBJECT);
      }
      return (obj != NULL_OBJECT ? obj : null);
    } else {
      return doGetObjectFromFactoryBean(factoryBean, beanName);
    }
  }

  private Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
    try {
      return factoryBean.getObject();
    } catch (Exception e) {
      throw new BeansException(
          "FactoryBean threw exception on object[" + beanName + "] creation", e);
    }
  }
}
