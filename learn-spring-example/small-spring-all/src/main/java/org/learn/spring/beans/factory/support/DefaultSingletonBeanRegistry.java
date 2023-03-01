package org.learn.spring.beans.factory.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.ObjectFactory;
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

  /** 一级缓存, 存放完全实例化的对象, beanName -> bean instance */
  private Map<String, Object> singletonObjects = new HashMap<>();

  /** 二级缓存, 存放还没有完全实例化的半成品对象, beanName -> bean instance */
  private Map<String, Object> earlySingletonObjects = new HashMap<>();

  /** 三级缓存, 存放工厂对象 */
  private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

  private final Map<String, DisposableBean> disposableBeanMap = new HashMap<>();

  @Override
  public Object getSingleton(String beanName) {
    Object singletonObject = singletonObjects.get(beanName);
    if (null == singletonObject) {
      singletonObject = earlySingletonObjects.get(beanName);
      if (null == singletonObject) {
        ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
        if (null != singletonFactory) {
          singletonObject = singletonFactory.getObject();
          // 从三级缓存中获取对象, 并放入二级缓存中
          earlySingletonObjects.put(beanName, singletonObject);
          singletonFactories.remove(beanName);
        }
      }
    }
    return singletonObject;
  }

  @Override
  public void registerSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
    earlySingletonObjects.remove(beanName);
    singletonFactories.remove(beanName);
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

  protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
    if (!this.singletonObjects.containsKey(beanName)) {
      this.singletonFactories.put(beanName, singletonFactory);
      this.earlySingletonObjects.remove(beanName);
    }
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
