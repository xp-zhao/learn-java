package java.org.learn.spring.beans.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.FactoryBean;

/**
 * FactoryBean 注册服务
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
  /** Cache of singleton objects created by FactoryBeans: FactoryBean name --> object */
  private final Map<String, Object> factoryBeanObjectCache =
      new ConcurrentHashMap<String, Object>();

  protected Object getCachedObjectForFactoryBean(String beanName) {
    Object obj = this.factoryBeanObjectCache.get(beanName);
    return (obj != NULL_OBJECT) ? obj : null;
  }

  protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
    if (factory.isSingleton()) {
      Object obj = this.factoryBeanObjectCache.get(beanName);
      if (obj == null) {
        obj = doGetObjectFromFactoryBean(factory, beanName);
        this.factoryBeanObjectCache.put(beanName, (obj != null ? obj : NULL_OBJECT));
      }
      return (obj != NULL_OBJECT ? obj : null);
    } else {
      return doGetObjectFromFactoryBean(factory, beanName);
    }
  }

  private Object doGetObjectFromFactoryBean(final FactoryBean factory, final String beanName) {
    try {
      return factory.getObject();
    } catch (Exception e) {
      throw new BeansException(
          "FactoryBean threw exception on object[" + beanName + "] creation", e);
    }
  }
}
