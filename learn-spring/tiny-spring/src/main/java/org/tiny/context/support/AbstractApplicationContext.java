package org.tiny.context.support;

import java.util.Map;
import org.tiny.beans.BeansException;
import org.tiny.beans.factory.ConfigurableListableBeanFactory;
import org.tiny.beans.factory.config.BeanFactoryPostProcessor;
import org.tiny.beans.factory.config.BeanPostProcessor;
import org.tiny.context.ConfigurableApplicationContext;
import org.tiny.core.io.DefaultResourceLoader;

/** @author zhaoxiaoping @Description: 抽象应用上下文 @Date 2021-8-24 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader
    implements ConfigurableApplicationContext {
  @Override
  public void refresh() throws BeansException {
    // 创建 BeanFactory, 加载 BeanDefinition
    refreshBeanFactory();
    // 获取 BeanFactory
    ConfigurableListableBeanFactory beanFactory = getBeanFactory();
    // 在 Bean 实例化之前，执行 BeanFactoryPostProcessor
    invokeBeanFactoryPostProcessors(beanFactory);
    // BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
    registerBeanPostProcessors(beanFactory);
    // 提前实例化单例对象
    beanFactory.preInstantiateSingletons();
  }

  /**
   * 创建 BeanFactory, 并加载 BeanDefinition
   *
   * @throws BeansException 异常
   */
  protected abstract void refreshBeanFactory() throws BeansException;

  /**
   * 获取 bean 对象工厂
   *
   * @return 对象工厂
   */
  protected abstract ConfigurableListableBeanFactory getBeanFactory();

  private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
    Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap =
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
    beanFactoryPostProcessorMap.values().forEach(item -> item.postProcessBeanFactory(beanFactory));
  }

  private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
    Map<String, BeanPostProcessor> beanPostProcessorMap =
        beanFactory.getBeansOfType(BeanPostProcessor.class);
    beanPostProcessorMap.values().forEach(beanFactory::addBeanPostProcessor);
  }

  @Override
  public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
    return getBeanFactory().getBeansOfType(type);
  }

  @Override
  public String[] getBeanDefinitionNames() {
    return getBeanFactory().getBeanDefinitionNames();
  }

  @Override
  public Object getBean(String name) throws BeansException {
    return getBeanFactory().getBean(name);
  }

  @Override
  public Object getBean(String name, Object... args) throws BeansException {
    return getBeanFactory().getBean(name, args);
  }

  @Override
  public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
    return getBeanFactory().getBean(name, requiredType);
  }
}
