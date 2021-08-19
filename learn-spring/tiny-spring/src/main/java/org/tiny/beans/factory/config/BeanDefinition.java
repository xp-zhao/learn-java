package org.tiny.beans.factory.config;

/** @author zhaoxiaoping @Description: bean 定义对象 @Date 2021-8-19 */
public class BeanDefinition {
  private Class<?> beanClass;

  public BeanDefinition(Class<?> beanClass) {
    this.beanClass = beanClass;
  }

  public Class<?> getBeanClass() {
    return beanClass;
  }

  public void setBeanClass(Class<?> beanClass) {
    this.beanClass = beanClass;
  }
}
