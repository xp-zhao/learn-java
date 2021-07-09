package org.smallspring.beans.factory.config;

/**
 * @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:15 下午
 */
public class BeanDefinition {

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
