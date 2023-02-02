package org.learn.spring.beans.factory.support;

import org.learn.spring.core.io.DefaultResourceLoader;
import org.learn.spring.core.io.ResourceLoader;

/**
 * BeanDefinition 加载器抽象类实现, 负责提供 BeanDefinition 注册接口, 资源加载器
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

  private final BeanDefinitionRegistry beanDefinitionRegistry;
  private ResourceLoader resourceLoader;

  public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
    this.beanDefinitionRegistry = beanDefinitionRegistry;
    this.resourceLoader = new DefaultResourceLoader();
  }

  public AbstractBeanDefinitionReader(
      BeanDefinitionRegistry beanDefinitionRegistry, ResourceLoader resourceLoader) {
    this.beanDefinitionRegistry = beanDefinitionRegistry;
    this.resourceLoader = resourceLoader;
  }

  @Override
  public BeanDefinitionRegistry getRegistry() {
    return beanDefinitionRegistry;
  }

  @Override
  public ResourceLoader getResourceLoader() {
    return resourceLoader;
  }
}
