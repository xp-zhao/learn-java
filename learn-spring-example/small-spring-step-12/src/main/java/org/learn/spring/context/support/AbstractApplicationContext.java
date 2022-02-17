package org.learn.spring.context.support;

import java.util.Collection;
import java.util.Map;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.ConfigurableListableBeanFactory;
import org.learn.spring.beans.factory.config.BeanFactoryPostProcessor;
import org.learn.spring.beans.factory.config.BeanPostProcessor;
import org.learn.spring.context.ApplicationEvent;
import org.learn.spring.context.ApplicationListener;
import org.learn.spring.context.ConfigurableApplicationContext;
import org.learn.spring.context.event.ApplicationEventMulticaster;
import org.learn.spring.context.event.ContextClosedEvent;
import org.learn.spring.context.event.ContextRefreshedEvent;
import org.learn.spring.context.event.SimpleApplicationEventMulticaster;
import org.learn.spring.core.io.DefaultResourceLoader;

/**
 * 应用上下文抽象类实现
 *
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader
    implements ConfigurableApplicationContext {

  public static final String APPLICATION_EVENT_MULTICASTER_BEAN_NAME =
      "applicationEventMulticaster";
  private ApplicationEventMulticaster applicationEventMulticaster;

  @Override
  public void refresh() throws BeansException {
    // 1. 创建 BeanFactory，并加载 BeanDefinition
    refreshBeanFactory();

    // 2. 获取 BeanFactory
    ConfigurableListableBeanFactory beanFactory = getBeanFactory();

    // 3. 添加 ApplicationContextAwareProcessor，让继承自 ApplicationContextAware 的 Bean 对象都能感知所属的
    // ApplicationContext
    beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));

    // 4. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor
    invokeBeanFactoryPostProcessors(beanFactory);

    // 5. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
    registerBeanPostProcessors(beanFactory);

    // 6. 初始化事件发布者
    initApplicationEventMulticaster();

    // 7. 注册事件监听器
    registerListeners();

    // 8. 提前实例化单例Bean对象
    beanFactory.preInstantiateSingletons();

    // 9. 发布容器刷新完成事件
    finishRefresh();
  }

  /**
   * 刷新bean工厂
   *
   * @throws BeansException 异常
   */
  protected abstract void refreshBeanFactory() throws BeansException;

  /**
   * 获得bean工厂
   *
   * @return {@code ConfigurableListableBeanFactory}
   */
  protected abstract ConfigurableListableBeanFactory getBeanFactory();

  private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
    Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap =
        beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
    for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
      beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
    }
  }

  private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
    Map<String, BeanPostProcessor> beanPostProcessorMap =
        beanFactory.getBeansOfType(BeanPostProcessor.class);
    for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
      beanFactory.addBeanPostProcessor(beanPostProcessor);
    }
  }

  private void initApplicationEventMulticaster() {
    ConfigurableListableBeanFactory beanFactory = getBeanFactory();
    applicationEventMulticaster = new SimpleApplicationEventMulticaster(beanFactory);
    beanFactory.registerSingleton(
        APPLICATION_EVENT_MULTICASTER_BEAN_NAME, applicationEventMulticaster);
  }

  private void registerListeners() {
    Collection<ApplicationListener> applicationListeners =
        getBeansOfType(ApplicationListener.class).values();
    for (ApplicationListener listener : applicationListeners) {
      applicationEventMulticaster.addApplicationListener(listener);
    }
  }

  private void finishRefresh() {
    publishEvent(new ContextRefreshedEvent(this));
  }

  @Override
  public void publishEvent(ApplicationEvent event) {
    applicationEventMulticaster.multicastEvent(event);
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

  @Override
  public void registerShutdownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread(this::close));
  }

  @Override
  public void close() {
    // 发布容器关闭事件
    publishEvent(new ContextClosedEvent(this));
    // 执行销毁单例bean的销毁方法
    getBeanFactory().destroySingletons();
  }
}
