package org.tiny.beans.factory.config;

import org.tiny.beans.PropertyValues;

/** @author zhaoxiaoping @Description: bean 定义对象 @Date 2021-8-19 */
public class BeanDefinition {
  private Class<?> beanClass;
  private PropertyValues propertyValues;

  public BeanDefinition(Class<?> beanClass) {
    this.beanClass = beanClass;
    this.propertyValues = new PropertyValues();
  }

  public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
    this.beanClass = beanClass;
    this.propertyValues = propertyValues;
  }

  public Class<?> getBeanClass() {
    return beanClass;
  }

  public void setBeanClass(Class<?> beanClass) {
    this.beanClass = beanClass;
  }

  public PropertyValues getPropertyValues() {
    return propertyValues;
  }

  public void setPropertyValues(PropertyValues propertyValues) {
    this.propertyValues = propertyValues;
  }
}
