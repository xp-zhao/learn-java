package org.smallspring.context;

import org.smallspring.beans.BeansException;

/** @author zhaoxiaoping @Description: 可配置的应用上下文接口 @Date 2021-8-23 */
public interface ConfigurableApplicationContext extends ApplicationContext {

  /**
   * 刷新容器
   *
   * @throws BeansException 异常
   */
  void refresh() throws BeansException;

  /** 注册钩子函数 */
  void registerShutdownHook();

  /** 关闭容器 */
  void close();
}
