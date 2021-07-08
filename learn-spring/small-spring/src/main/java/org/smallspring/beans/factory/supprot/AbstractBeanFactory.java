package org.smallspring.beans.factory.supprot;

import org.smallspring.beans.factory.BeanFactory;
import org.smallspring.beans.factory.config.BeanDefinition;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/8 11:38 下午 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
    implements BeanFactory {

  @Override
  public Object getBean(String name) {
    Object object = getSingleton(name);
    if (object != null) {
      return object;
    }
    BeanDefinition beanDefinition = getBeanDefinition(name);

    return createBean(name, beanDefinition);
  }

  protected abstract BeanDefinition getBeanDefinition(String beanName);

  protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
