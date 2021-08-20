package org.tiny.beans;

import java.util.ArrayList;
import java.util.List;

/** @author zhaoxiaoping @Description: 类属性集合 @Date 2021-8-20 */
public class PropertyValues {
  private final List<PropertyValue> propertyValueList = new ArrayList<>();

  public void addPropertyValue(PropertyValue pv) {
    this.propertyValueList.add(pv);
  }

  public PropertyValue[] getPropertyValues() {
    return this.propertyValueList.toArray(new PropertyValue[0]);
  }

  public PropertyValue getPropertyValue(String propertyName) {
    for (PropertyValue pv : this.propertyValueList) {
      if (pv.getName().equals(propertyName)) {
        return pv;
      }
    }
    return null;
  }
}
