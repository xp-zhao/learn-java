package bean;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.PropertyValue;
import org.smallspring.beans.PropertyValues;
import org.smallspring.beans.factory.ConfigurableListableBeanFactory;
import org.smallspring.beans.factory.config.BeanDefinition;
import org.smallspring.beans.factory.config.BeanFactoryPostProcessor;

/** @author zhaoxiaoping @Description: @Date 2021-8-23 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {
    BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
    PropertyValues propertyValues = beanDefinition.getPropertyValues();

    propertyValues.addPropertyValue(new PropertyValue("company", "改为：company修改"));
  }
}
