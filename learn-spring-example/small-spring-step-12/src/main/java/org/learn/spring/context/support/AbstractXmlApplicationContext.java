package org.learn.spring.context.support;

import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;
import org.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
  @Override
  protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
    String[] configLocations = getConfigLocations();
    if (null != configLocations) {
      beanDefinitionReader.loadBeanDefinitions(configLocations);
    }
  }

  /**
   * 得到配置位置
   *
   * @return {@code String[]}
   */
  protected abstract String[] getConfigLocations();
}
