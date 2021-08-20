package org.tiny.beans;

/** @author zhaoxiaoping @Description: 类属性信息对象 @Date 2021-8-20 */
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
