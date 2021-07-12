package org.smallspring.beans.factory.config;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/12 11:36 下午 */
public class BeanReference {
  private final String beanName;

  public BeanReference(String beanName) {
    this.beanName = beanName;
  }

  public String getBeanName() {
    return beanName;
  }
}
