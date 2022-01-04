package org.learn.spring;

/**
 * bean 定义类，用于定义 Bean 的实例化信息
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class BeanDefinition {

  /** 存放 bean 对象 */
  private Object bean;

  public BeanDefinition(Object bean) {
    this.bean = bean;
  }

  public Object getBean() {
    return bean;
  }
}
