package org.smallspring.beans.factory.supprot;

import java.lang.reflect.Constructor;
import org.smallspring.beans.factory.config.BeanDefinition;

/**
 * @author zhaoxiaoping
 * @Description: 实例化策略
 * @Date 2021-7-10
 **/
public interface InstantiationStrategy {
  
  Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor,
      Object[] args);
}
