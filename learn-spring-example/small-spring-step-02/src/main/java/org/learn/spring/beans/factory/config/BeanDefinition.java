package org.learn.spring.beans.factory.config;

/**
 * Bean 定义类
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class BeanDefinition {

  /** 只存储对象的 class, 将 Bean 的实例化操作放到容器中 */
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
