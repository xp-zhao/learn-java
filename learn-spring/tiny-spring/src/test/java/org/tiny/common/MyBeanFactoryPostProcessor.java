package org.tiny.common;

import org.tiny.beans.BeansException;
import org.tiny.beans.PropertyValue;
import org.tiny.beans.PropertyValues;
import org.tiny.beans.factory.ConfigurableListableBeanFactory;
import org.tiny.beans.factory.config.BeanDefinition;
import org.tiny.beans.factory.config.BeanFactoryPostProcessor;

/** @author zhaoxiaoping @Description: @Date 2021-8-24 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
    PropertyValues propertyValues = beanDefinition.getPropertyValues();

    propertyValues.addPropertyValue(new PropertyValue("company", "company 修改"));
  }
}
