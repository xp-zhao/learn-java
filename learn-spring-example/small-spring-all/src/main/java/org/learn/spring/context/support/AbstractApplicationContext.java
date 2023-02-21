package org.learn.spring.context.support;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.ConfigurableListableBeanFactory;
import org.learn.spring.beans.factory.config.BeanFactoryPostProcessor;
import org.learn.spring.beans.factory.config.BeanPostProcessor;
import org.learn.spring.context.ConfigurableApplicationContext;
import org.learn.spring.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * 应用上下文抽象类实现, 负责定义容器刷新逻辑, 并实现 BeanFactory 部分方法
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader
    implements ConfigurableApplicationContext {
  @Override
  public void refresh() throws BeansException {
    // 创建 BeanFactory 并加载 BeanDefinition
    refreshBeanFactory();
    // 获取 BeanFactory
    ConfigurableListableBeanFactory beanFactory = getBeanFactory();
    // 添加 ApplicationContextAwareProcessor , 让继承 ApplicationContextAware 的 Bean 对象能感知到所属的
    // ApplicationContext
    beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
    // 在 bean 对象实例化之前, 执行 BeanFactoryProcessors (用于修改 BeanDefinition)
    invokeBeanFactoryPostProcessors(beanFactory);
    // 在 bean 对象实例化之前, 注册 BeanPostProcessors (用于在 bean 对象实例化之后修改 bean 对象)
    registerBeanPostProcessors(beanFactory);
    // 提前实例化单例对象
    beanFactory.preInstantiateSingletons();
  }

  @Override
  public Object getBean(String beanName) throws BeansException {
    return getBeanFactory().getBean(beanName);
  }

  @Override
  public Object getBean(String beanName, Object... args) throws BeansException {
    return getBeanFactory().getBean(beanName, args);
  }

  @Override
  public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
    return getBeanFactory().getBean(name, requiredType);
  }

  @Override
  public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
    return getBeanFactory().getBeansOfType(type);
  }

  /**
   * 创建 BeanFactory 并加载 BeanDefinition
   *
   * @throws BeansException
   */
  protected abstract void refreshBeanFactory() throws BeansException;

  /**
   * 获取 BeanFactory
   *
   * @return
   */
  protected abstract ConfigurableListableBeanFactory getBeanFactory();

  private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
    Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessMap =
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
    for (BeanFactoryPostProcessor postProcessor : beanFactoryPostProcessMap.values()) {
      postProcessor.postProcessBeanFactory(beanFactory);
    }
  }

  private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
    Map<String, BeanPostProcessor> beanPostProcessorMap =
        beanFactory.getBeansOfType(BeanPostProcessor.class);
    for (BeanPostProcessor postProcessor : beanPostProcessorMap.values()) {
      beanFactory.addBeanPostProcessor(postProcessor);
    }
  }

  @Override
  public void registerShutdownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread(this::close));
  }

  @Override
  public void close() {
    getBeanFactory().destroySingletons();
  }
}
