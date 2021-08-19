package org.tiny;

/** @author zhaoxiaoping @Description: bean 定义对象 @Date 2021-8-19 */
public class BeanDefinition {
  private Object bean;

  public BeanDefinition(Object bean) {
    this.bean = bean;
  }

  public Object getBean() {
    return bean;
  }
}
