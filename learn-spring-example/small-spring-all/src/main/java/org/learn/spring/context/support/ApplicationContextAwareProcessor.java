package org.learn.spring.context.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.config.BeanPostProcessor;
import org.learn.spring.context.ApplicationContext;
import org.learn.spring.context.ApplicationContextAware;

/**
 * ApplicationContextAware 包装处理器
 *
 * @author zhaoxiaoping
 * @date 2023-2-21
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
