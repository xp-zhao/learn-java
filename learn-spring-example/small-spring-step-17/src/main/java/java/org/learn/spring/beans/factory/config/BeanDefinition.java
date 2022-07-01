package java.org.learn.spring.beans.factory.config;

import org.learn.spring.beans.PropertyValues;

/**
 * Bean 定义类
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class BeanDefinition {

  String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

  String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

  /** 只存储对象的 class, 将 Bean 的实例化操作放到容器中 */
  private Class beanClass;
  /** 属性值 */
  private PropertyValues propertyValues;
  /** 初始化方法名称 */
  private String initMethodName;
  /** 销毁方法名称 */
  private String destroyMethodName;

  private String scope = SCOPE_SINGLETON;

  private boolean singleton = true;

  private boolean prototype = false;

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
