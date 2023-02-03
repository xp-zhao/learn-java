package org.learn.spring.context.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.ConfigurableListableBeanFactory;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;

/**
 * ApplicationContext 抽象类实现, 负责创建 BeanFactory 并加载 BeanDefinition
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
  private DefaultListableBeanFactory beanFactory;

  @Override
  protected void refreshBeanFactory() throws BeansException {
    DefaultListableBeanFactory beanFactory = createBeanFactory();
    loadBeanDefinitions(beanFactory);
    this.beanFactory = beanFactory;
  }

  /**
   * 加载 BeanDefinition
   *
   * @param beanFactory
   */
  protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

  private DefaultListableBeanFactory createBeanFactory() {
    return new DefaultListableBeanFactory();
  }

  protected ConfigurableListableBeanFactory getBeanFactory() {
    return beanFactory;
  }
}
