package org.tiny.beans.factory.support;

import org.tiny.core.io.DefaultResourceLoader;
import org.tiny.core.io.ResourceLoader;

/** @author zhaoxiaoping @Description: bean 定义获取接口抽象类实现 @Date 2021-8-20 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
  private final BeanDefinitionRegistry registry;

  private ResourceLoader resourceLoader;

  protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
    this(registry, new DefaultResourceLoader());
  }

  public AbstractBeanDefinitionReader(
      BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
    this.registry = registry;
    this.resourceLoader = resourceLoader;
  }

  @Override
  public BeanDefinitionRegistry getRegistry() {
    return registry;
  }

  @Override
  public ResourceLoader getResourceLoader() {
    return resourceLoader;
  }
}
