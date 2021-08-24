package org.tiny.context.support;

import org.tiny.beans.BeansException;

/** @author zhaoxiaoping @Description: 从 classpath 中读取信息 @Date 2021-8-24 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

  private String[] configLocations;

  public ClassPathXmlApplicationContext() {}

  public ClassPathXmlApplicationContext(String configLocations) {
    this(new String[] {configLocations});
  }

  /**
   * 从 XML 中加载 BeanDefinition，并刷新上下文
   *
   * @param configLocations xml 地址
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
