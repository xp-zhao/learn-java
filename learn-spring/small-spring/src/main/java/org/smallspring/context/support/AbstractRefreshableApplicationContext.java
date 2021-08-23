package org.smallspring.context.support;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.ConfigurableListableBeanFactory;
import org.smallspring.beans.factory.supprot.DefaultListableBeanFactory;

/** @author zhaoxiaoping @Description: @Date 2021-8-23 */
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

  protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

  @Override
  protected ConfigurableListableBeanFactory getBeanFactory() {
    return beanFactory;
  }
}
