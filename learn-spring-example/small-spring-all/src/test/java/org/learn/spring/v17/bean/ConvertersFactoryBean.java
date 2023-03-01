package org.learn.spring.v17.bean;

import org.learn.spring.beans.factory.FactoryBean;

import java.util.HashSet;
import java.util.Set;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-3-1
 */
public class ConvertersFactoryBean implements FactoryBean<Set<?>> {

  @Override
  public Set<?> getObject() throws Exception {
    HashSet<Object> converters = new HashSet<>();
    StringToLocalDateConverter stringToLocalDateConverter =
        new StringToLocalDateConverter("yyyy-MM-dd");
    converters.add(stringToLocalDateConverter);
    return converters;
  }

  @Override
  public Class<?> getObjectType() {
    return null;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }
}
