package org.learn.spring.beans.factory.config;

import org.learn.spring.beans.PropertyValues;

/**
 * Bean 定义对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class BeanDefinition {

  String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;
  String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

  /** 存放 Bean 对象的 class, 将 Bean 的实例化操作放在容器中 */
  private Class beanClass;

  /** 存放 Bean 对象的属性信息 */
  private PropertyValues propertyValues;

  private String scope = SCOPE_SINGLETON;

  private boolean singleton = true;
  private boolean prototype = false;

  /** 初始化方法的名称 */
  private String initMethodName;

  /** 销毁方法的名称 */
  private String destroyMethodName;

  public BeanDefinition(Class beanClass) {
    this.beanClass = beanClass;
    this.propertyValues = new PropertyValues();
  }

  public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
    this.beanClass = beanClass;
    this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
  }

  public void setScope(String scope) {
    this.scope = scope;
    this.singleton = SCOPE_SINGLETON.equals(scope);
    this.prototype = SCOPE_PROTOTYPE.equals(scope);
  }

  public boolean isSingleton() {
    return singleton;
  }

  public boolean isPrototype() {
    return prototype;
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
