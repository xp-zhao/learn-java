package org.smallspring.beans.factory.config;

import org.smallspring.beans.PropertyValues;

/**
 * @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:15 下午
 */
public class BeanDefinition {

  private Class beanClass;

  private PropertyValues propertyValues;

  private String initMethodName;

  private String destroyMethodName;

  public BeanDefinition(Class beanClass) {
    this.beanClass = beanClass;
    this.propertyValues = new PropertyValues();
  }

  public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
    this.beanClass = beanClass;
    this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
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

  public String getInitMethodName() {
    return initMethodName;
  }

  public void setInitMethodName(String initMethodName) {
    this.initMethodName = initMethodName;
  }

  public String getDestroyMethodName() {
    return destroyMethodName;
  }

  public void setDestroyMethodName(String destroyMethodName) {
    this.destroyMethodName = destroyMethodName;
  }
}
