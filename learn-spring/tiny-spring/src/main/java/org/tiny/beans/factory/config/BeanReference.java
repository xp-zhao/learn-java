package org.tiny.beans.factory.config;

/** @author zhaoxiaoping @Description: 类引用对象 @Date 2021-8-20 */
public class BeanReference {
  private final String beanName;

  public BeanReference(String beanName) {
    this.beanName = beanName;
  }

  public String getBeanName() {
    return beanName;
  }
}
