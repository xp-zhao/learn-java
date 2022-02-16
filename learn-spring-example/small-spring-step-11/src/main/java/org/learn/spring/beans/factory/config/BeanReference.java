package org.learn.spring.beans.factory.config;

/**
 * Bean 引用
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
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
