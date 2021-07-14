package org.smallspring.beans;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-10
 **/
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
