package org.litespring.beans.factory.config;

/**
 * @author xp-zhao
 * @date 2018/7/25
 */
public class RuntimeBeanReference {

  private final String beanName;

  public RuntimeBeanReference(String beanName) {
    this.beanName = beanName;
  }

  public String getBeanName() {
    return this.beanName;
  }
}
