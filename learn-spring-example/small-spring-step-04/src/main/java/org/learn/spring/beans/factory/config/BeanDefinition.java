package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.factory.PropertyValues;

/**
 * Bean 定义类
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class BeanDefinition {

  /** 只存储对象的 class, 将 Bean 的实例化操作放到容器中 */
  private Class beanClass;
  /** 属性值 */
  private PropertyValues propertyValues;

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
}
