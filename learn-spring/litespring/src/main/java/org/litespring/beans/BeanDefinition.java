package org.litespring.beans;

import java.util.List;

/**
 * 存储 bean 的定义信息
 *
 * @author xp-zhao
 * @date 2018/7/8
 */
public interface BeanDefinition {

  String SCOPE_SINGLETON = "singleton";
  String SCOPE_PROTOTYPE = "prototype";
  String SCOPE_DEFAULT = "";

  /**
   * 是否是单例类
   *
   * @return true/false
   */
  boolean isSingleton();

  /**
   * 是否是原型类
   *
   * @return true/false
   */
  boolean isPrototype();

  /**
   * 获取类的范围
   *
   * @return 类的范围
   */
  String getScope();

  /**
   * 设置类的范围
   *
   * @param scope 类的范围
   */
  void setScope(String scope);

  /**
   * 获取 bean 的名称
   *
   * @return bean 名称
   */
  String getBeanClassName();

  /**
   * 获取类的属性值
   *
   * @return 属性值列表
   */
  List<PropertyValue> getPropertyValues();

  /**
   * 获取类的构造参数
   *
   * @return 构造参数
   */
  ConstructorArgument getConstructorArgument();

  /**
   * 或取 beanId
   *
   * @return beanId
   */
  String getId();

  /**
   * 是否具有构造参数
   *
   * @return true/false
   */
  boolean hasConstructorArgumentValues();

  /**
   * 解析 bean class
   * @param classLoader 类加载器
   * @return class 对象
   * @throws ClassNotFoundException 异常
   */
  Class<?> resolveBeanClass(ClassLoader classLoader) throws ClassNotFoundException;

  /**
   * 获取 bean class
   * @return class 对象
   * @throws IllegalStateException 异常
   */
  Class<?> getBeanClass() throws IllegalStateException ;

  /**
   * 判断是否有 bean class
   * @return true/false
   */
  boolean hasBeanClass();
}
