package org.learn.spring.context.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.ConfigurableListableBeanFactory;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
  private DefaultListableBeanFactory beanFactory;

  @Override
  protected void refreshBeanFactory() throws BeansException {
    DefaultListableBeanFactory beanFactory = createBeanFactory();
    loadBeanDefinitions(beanFactory);
    this.beanFactory = beanFactory;
  }

  private DefaultListableBeanFactory createBeanFactory() {
    return new DefaultListableBeanFactory();
  }

  /**
   * 加载bean定义
   *
   * @param beanFactory bean工厂
   */
  protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

  @Override
  protected ConfigurableListableBeanFactory getBeanFactory() {
    return beanFactory;
  }
}
