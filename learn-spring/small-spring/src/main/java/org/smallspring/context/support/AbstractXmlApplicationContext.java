package org.smallspring.context.support;

import org.smallspring.beans.factory.supprot.DefaultListableBeanFactory;
import org.smallspring.beans.factory.xml.XmlBeanDefinitionReader;

/** @author zhaoxiaoping @Description: @Date 2021-8-23 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
  @Override
  protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
    String[] configLocations = getConfigLocations();
    if (null != configLocations) {
      beanDefinitionReader.loadBeanDefinitions(configLocations);
    }
  }

  protected abstract String[] getConfigLocations();
}
