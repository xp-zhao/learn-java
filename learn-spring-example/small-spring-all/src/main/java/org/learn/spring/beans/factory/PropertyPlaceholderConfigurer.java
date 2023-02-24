package org.learn.spring.beans.factory;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanFactoryPostProcessor;
import org.learn.spring.core.io.DefaultResourceLoader;
import org.learn.spring.core.io.Resource;

import java.util.Properties;

/**
 * 属性占位符配置器
 *
 * @author zhaoxiaoping
 * @date 2023-2-24
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

  /** Default placeholder prefix: {@value} */
  public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";
  /** Default placeholder suffix: {@value} */
  public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

  private String location;

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    try {
      DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
      Resource resource = resourceLoader.getResource(location);
      Properties properties = new Properties();
      properties.load(resource.getInputStream());
      String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
      for (String beanName : beanDefinitionNames) {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
          Object value = propertyValue.getValue();
          if (!(value instanceof String)) {
            continue;
          }
          String strVal = (String) value;
          StringBuilder builder = new StringBuilder(strVal);
          int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
          int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
          if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
            String propKey = strVal.substring(startIdx + 2, stopIdx);
            String propVal = properties.getProperty(propKey);
            builder.replace(startIdx, stopIdx + 1, propVal);
            propertyValues.addPropertyValue(
                    new PropertyValue(propertyValue.getName(), builder.toString()));
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
