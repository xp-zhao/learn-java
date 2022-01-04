package org.learn.spring.beans.factory;

/**
 * Bean 属性信息
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
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
