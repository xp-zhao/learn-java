package org.tiny.context;

import org.tiny.beans.BeansException;

/** @author zhaoxiaoping @Description: 可配置的应用上下文 @Date 2021-8-24 */
public interface ConfigurableApplicationContext extends ApplicationContext {

  /**
   * 属性容器
   *
   * @throws BeansException 异常
   */
  void refresh() throws BeansException;
}
