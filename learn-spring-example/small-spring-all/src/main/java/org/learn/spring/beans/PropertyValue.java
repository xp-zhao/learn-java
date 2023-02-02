package org.learn.spring.beans;

/**
 * Bean 属性信息
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class PropertyValue {
  private final String name;
  private final Object value;

  public PropertyValue(String name, Object value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public Object getValue() {
    return value;
  }
}
