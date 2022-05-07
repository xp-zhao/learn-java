package org.learn.spring.beans.factory.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.ObjectFactory;
import org.learn.spring.beans.factory.config.SingletonBeanRegistry;

/**
 * 默认单例接口实现
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

  protected static final Object NULL_OBJECT = new Object();

  /**
   * 一级缓存，普通对象<br>
   * Cache of singleton objects: bean name --> bean instance
   */
  private Map<String, Object> singletonObjects = new HashMap<>();
  /**
   * 二级缓存，提前暴漏对象，没有完全实例化的对象<br>
   * Cache of early singleton objects: bean name --> bean instance
   */
  protected final Map<String, Object> earlySingletonObjects = new HashMap<>();

  /**
   * 三级缓存，存放代理对象<br>
   * Cache of singleton factories: bean name --> ObjectFactory
   */
  private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

  private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

  @Override
  public Object getSingleton(String beanName) {
    Object singletonObject = singletonObjects.get(beanName);
    if (null == singletonObject) {
      singletonObject = earlySingletonObjects.get(beanName);
      if (null == singletonObject) {
        ObjectFactory<?> singletonFactory = singletonFactories.get(beanName);
        if (singletonFactory != null) {
          singletonObject = singletonFactory.getObject();
          // 把三级缓存中的代理对象中的真实对象获取出来，放入二级缓存中
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

  protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
    if (!this.singletonObjects.containsKey(beanName)) {
      this.singletonFactories.put(beanName, singletonFactory);
      this.earlySingletonObjects.remove(beanName);
    }
  }

  public void registerDisposableBean(String beanName, DisposableBean bean) {
    disposableBeans.put(beanName, bean);
  }

  public void destroySingletons() {
    Set<String> keySet = this.disposableBeans.keySet();
    Object[] disposableBeanNames = keySet.toArray();

    for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
      Object beanName = disposableBeanNames[i];
      DisposableBean disposableBean = disposableBeans.remove(beanName);
      try {
        disposableBean.destroy();
      } catch (Exception e) {
        throw new BeansException(
            "Destroy method on bean with name '" + beanName + "' threw an exception", e);
      }
    }
  }
}
