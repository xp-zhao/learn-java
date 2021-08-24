package org.tiny.context.support;

import org.tiny.beans.factory.support.DefaultListableBeanFactory;
import org.tiny.beans.factory.xml.XmlBeanDefinitionReader;

/** @author zhaoxiaoping @Description: 从 xml 中加载 BeanDefinition @Date 2021-8-24 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
  @Override
  protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory, this);
    String[] configLocations = getConfigLocations();
    if (null != configLocations) {
      reader.loadBeanDefinitions(configLocations);
    }
  }

  /**
   * 获取资源地址
   *
   * @return 资源地址数组
   */
  protected abstract String[] getConfigLocations();
}
