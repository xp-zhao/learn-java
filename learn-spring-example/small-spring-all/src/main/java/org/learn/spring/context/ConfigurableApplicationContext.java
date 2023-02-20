package org.learn.spring.context;

import org.learn.spring.beans.BeansException;

/**
 * 应用上下文拓展接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
  /**
   * 刷新容器
   *
   * @throws BeansException
   */
  void refresh() throws BeansException;

  /** 注册关闭钩子 */
  void registerShutdownHook();

  /** 手动关闭 */
  void close();
}
