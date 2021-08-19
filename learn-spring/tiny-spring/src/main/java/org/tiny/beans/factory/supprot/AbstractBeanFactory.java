package org.tiny.beans.factory.supprot;

import org.tiny.beans.BeansException;
import org.tiny.beans.factory.BeanFactory;
import org.tiny.beans.factory.config.BeanDefinition;

/** @author zhaoxiaoping @Description: 抽象 bean 工厂 @Date 2021-8-19 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry
    implements BeanFactory {
  @Override
  public Object getBean(String beanName) throws BeansException {
    Object object = getSingleton(beanName);
    if (object != null) {
      return object;
    }
    BeanDefinition beanDefinition = getBeanDefinition(beanName);
    return createBean(beanName, beanDefinition);
  }

  /**
   * 通过 bean 名称获取 BeanDefinition 对象
   *
   * @param beanName bean 名称
   * @return bean 定义对象
   * @throws BeansException 找不到时抛出
   */
  protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 创建 bean 对象
   *
   * @param beanName 名称
   * @param beanDefinition 定义对象
   * @return bean 对象
   * @throws BeansException 创建失败时抛出
   */
  protected abstract Object createBean(String beanName, BeanDefinition beanDefinition)
      throws BeansException;
}
