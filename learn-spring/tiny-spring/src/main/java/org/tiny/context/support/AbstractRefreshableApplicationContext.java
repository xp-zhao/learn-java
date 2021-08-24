package org.tiny.context.support;

import org.tiny.beans.BeansException;
import org.tiny.beans.factory.ConfigurableListableBeanFactory;
import org.tiny.beans.factory.support.DefaultListableBeanFactory;

/** @author zhaoxiaoping @Description: 提供创建 bean 对象工厂, 并加载 BeanDefinition 的方法 @Date 2021-8-24 */
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
   * 加载 BeanDefinition
   *
   * @param beanFactory bean 对象工厂
   */
  protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

  @Override
  protected ConfigurableListableBeanFactory getBeanFactory() {
    return beanFactory;
  }
}
