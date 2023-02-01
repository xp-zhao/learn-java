package org.learn.spring.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Bean 属性对象集合
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
public class PropertyValues {
  private List<PropertyValue> propertyValueList = new ArrayList<>();

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
