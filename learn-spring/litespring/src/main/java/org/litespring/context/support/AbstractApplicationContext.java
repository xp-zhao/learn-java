package org.litespring.context.support;

import org.litespring.beans.factory.support.DefaultBeanFactory;
import org.litespring.beans.factory.xml.XmlBeanDefinitionReader;
import org.litespring.context.ApplicationContext;
import org.litespring.core.io.Resource;
import org.litespring.util.ClassUtils;

/**
 * @author xp-zhao
 * @date 2018/7/23
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

  private DefaultBeanFactory factory;
  private ClassLoader beanClassLoader;

  public AbstractApplicationContext(String configFile) {
    factory = new DefaultBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
    Resource resource = this.getResourceByPath(configFile);
    reader.loadBeanDefinitions(resource);
    factory.setBeanClassLoader(this.getBeanClassLoader());
  }

  /**
   * 通过路径读取资源
   *
   * @param path 资源路径
   * @return 资源
   */
  protected abstract Resource getResourceByPath(String path);

  public Object getBean(String beanId) {
    return factory.getBean(beanId);
  }

  public void setBeanClassLoader(ClassLoader beanClassLoader) {
    this.beanClassLoader = beanClassLoader;
  }

  public ClassLoader getBeanClassLoader() {
    return (this.beanClassLoader != null ? this.beanClassLoader
        : ClassUtils.getDefaultClassLoader());
  }
}
