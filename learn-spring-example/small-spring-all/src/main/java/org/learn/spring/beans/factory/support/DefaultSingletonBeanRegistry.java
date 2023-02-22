package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 默认单例注册接口实现
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

  protected static final Object NULL_OBJECT = new Object();

  private Map<String, Object> singletonObjects = new HashMap<>();

  private final Map<String, DisposableBean> disposableBeanMap = new HashMap<>();

  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  @Override
  public void registerSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }

  /**
   * 注册单例对象
   *
   * @param beanName
   * @param singletonObject
   */
  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }

  public void registerDisposableBean(String beanName, DisposableBean bean) {
    disposableBeanMap.put(beanName, bean);
  }

  public void destroySingletons() {
    Set<String> keySet = this.disposableBeanMap.keySet();
    Object[] disposableBeanNames = keySet.toArray();
    for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
      Object beanName = disposableBeanNames[i];
      DisposableBean disposableBean = disposableBeanMap.remove(beanName);
      try {
        disposableBean.destroy();
      } catch (Exception e) {
        throw new BeansException(
            "Destroy method on bean with name '" + beanName + "' threw an exception", e);
      }
    }
  }
}
