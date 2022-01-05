package org.smallspring.context.support;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.BeanPostProcessor;
import org.smallspring.context.ApplicationContext;
import org.smallspring.context.ApplicationContextAware;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/1/5
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
  private final ApplicationContext applicationContext;

  public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (bean instanceof ApplicationContextAware) {
      ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
}
