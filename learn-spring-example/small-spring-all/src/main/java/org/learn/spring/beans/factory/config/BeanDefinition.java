package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.factory.PropertyValues;

/**
 * Bean 定义对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class BeanDefinition {
  /** 存放 Bean 对象的 class, 将 Bean 的实例化操作放在容器中 */
  private Class beanClass;

  /** 存放 Bean 对象的属性信息 */
  private PropertyValues propertyValues;

  public BeanDefinition(Class beanClass) {
    this.beanClass = beanClass;
    this.propertyValues = new PropertyValues();
  }

  public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
    this.beanClass = beanClass;
    this.propertyValues = propertyValues;
  }

  public Class getBeanClass() {
    return beanClass;
  }

  public void setBeanClass(Class beanClass) {
    this.beanClass = beanClass;
  }

  public PropertyValues getPropertyValues() {
    return propertyValues;
  }

  public void setPropertyValues(PropertyValues propertyValues) {
    this.propertyValues = propertyValues;
  }
}
