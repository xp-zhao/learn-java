package org.learn.spring;

/**
 * Bean 对象, 用于定义 Bean 的实例化信息
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class BeanDefinition {
  /** 存放 Bean 对象 */
  private Object bean;

  public BeanDefinition(Object bean) {
    this.bean = bean;
  }

  public Object getBean() {
    return bean;
  }
}
