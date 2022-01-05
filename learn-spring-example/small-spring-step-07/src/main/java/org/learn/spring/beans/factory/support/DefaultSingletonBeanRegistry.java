package org.learn.spring.beans.factory.support;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.config.SingletonBeanRegistry;

/**
 * 默认单例接口实现
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

  private Map<String, Object> singletonObjects = new HashMap<>();
  private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  /**
   * 添加单例对象
   *
   * @param beanName bean的名字
   * @param singletonObject 单例对象
   */
  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
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
