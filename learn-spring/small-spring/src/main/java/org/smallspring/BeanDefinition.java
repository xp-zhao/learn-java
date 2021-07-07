package org.smallspring;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:15 下午 */
public class BeanDefinition {
  private Object bean;

  public BeanDefinition(Object bean) {
    this.bean = bean;
  }

  public Object getBean() {
    return bean;
  }
}
