package org.learn.spring.context.support;

import org.learn.spring.beans.BeansException;

/**
 * 应用上下文实现类
 *
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

  private String[] configLocations;

  public ClassPathXmlApplicationContext() {}

  /**
   * 从 XML 中加载 BeanDefinition，并刷新上下文
   *
   * @param configLocations 配置位置
   * @throws BeansException 异常
   */
  public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
    this(new String[] {configLocations});
  }

  /**
   * 从 XML 中加载 BeanDefinition，并刷新上下文
   *
   * @param configLocations 配置位置
   * @throws BeansException 异常
   */
  public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
    this.configLocations = configLocations;
    refresh();
  }

  @Override
  protected String[] getConfigLocations() {
    return configLocations;
  }
}
