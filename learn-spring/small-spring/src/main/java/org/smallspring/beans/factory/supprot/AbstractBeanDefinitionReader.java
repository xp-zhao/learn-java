package org.smallspring.beans.factory.supprot;

import org.smallspring.core.io.DefaultResourceLoader;
import org.smallspring.core.io.ResourceLoader;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-8-17
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

  private final BeanDefinitionRegistry registry;

  private ResourceLoader resourceLoader;

  protected AbstractBeanDefinitionReader(
      BeanDefinitionRegistry registry) {
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
