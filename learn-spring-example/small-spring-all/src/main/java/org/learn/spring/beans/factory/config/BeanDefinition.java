package org.learn.spring.beans.factory.config;

/**
 * Bean 定义对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class BeanDefinition {
  /** 存放 Bean 对象的 class, 将 Bean 的实例化操作放在容器中 */
  private Class beanClass;

  public BeanDefinition(Class beanClass) {
    this.beanClass = beanClass;
  }

  public Class getBeanClass() {
    return beanClass;
  }

  public void setBeanClass(Class beanClass) {
    this.beanClass = beanClass;
  }
}
