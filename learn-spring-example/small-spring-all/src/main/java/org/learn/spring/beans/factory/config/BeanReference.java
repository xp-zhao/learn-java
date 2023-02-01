package org.learn.spring.beans.factory.config;

/**
 * Bean 引用对象
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class BeanReference {
  private final String beanName;

  public BeanReference(String beanName) {
    this.beanName = beanName;
  }

  public String getBeanName() {
    return beanName;
  }
}
