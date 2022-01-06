package org.learn.spring.beans.common;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.ConfigurableListableBeanFactory;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
    PropertyValues propertyValues = beanDefinition.getPropertyValues();
    propertyValues.addPropertyValue(new PropertyValue("location", "location 修改"));
  }
}
