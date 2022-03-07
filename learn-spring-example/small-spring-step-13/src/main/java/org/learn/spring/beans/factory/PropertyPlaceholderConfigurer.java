package org.learn.spring.beans.factory;

import java.io.IOException;
import java.util.Properties;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.PropertyValue;
import org.learn.spring.beans.PropertyValues;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.config.BeanFactoryPostProcessor;
import org.learn.spring.core.io.DefaultResourceLoader;
import org.learn.spring.core.io.Resource;

/**
 * 属性占位符配置
 *
 * @author zhaoxiaoping
 * @date 2022-3-7
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
    // 加载属性文件
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
          StringBuilder buffer = new StringBuilder(strVal);
          int startIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
          int stopIdx = strVal.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
          if (startIdx != -1 && stopIdx != -1 && startIdx < stopIdx) {
            String propKey = strVal.substring(startIdx + 2, stopIdx);
            String propVal = properties.getProperty(propKey);
            buffer.replace(startIdx, stopIdx + 1, propVal);
            propertyValues.addPropertyValue(
                new PropertyValue(propertyValue.getName(), buffer.toString()));
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
