package org.learn.spring.context.support;

import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;
import org.learn.spring.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * 应用上下文抽象类实现, 负责从 xml 中加载 BeanDefinition
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
  protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
    XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
    String[] configLocations = getConfigLocations();
    if (null != configLocations) {
      beanDefinitionReader.loadBeanDefinitions(configLocations);
    }
  }

  /**
   * 获取配置文件位置
   *
   * @return
   */
  protected abstract String[] getConfigLocations();
}
