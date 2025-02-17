package org.litespring.beans.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.litespring.beans.factory.config.SingletonBeanRegistry;
import org.litespring.util.Assert;

/**
 * @author xp-zhao
 * @date 2018/7/24
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

  private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(64);

  @Override
  public void registerSingleton(String beanName, Object singletonObject) {

    Assert.notNull(beanName, "'beanName' must not be null");

    Object oldObject = this.singletonObjects.get(beanName);
    if (oldObject != null) {
      throw new IllegalStateException("Could not register object [" + singletonObject +
          "] under bean name '" + beanName + "': there is already object [" + oldObject
          + "] bound");
    }
    this.singletonObjects.put(beanName, singletonObject);

  }

  @Override
  public Object getSingleton(String beanName) {

    return this.singletonObjects.get(beanName);
  }

}
