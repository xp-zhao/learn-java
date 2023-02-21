package org.learn.spring.context;

import org.learn.spring.beans.factory.Aware;

/**
 * bean 对象所属 ApplicationContext 感知接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-21
 */
public interface ApplicationContextAware extends Aware {
  /**
   * 设置应用程序上下文
   *
   * @param applicationContext
   */
  void setApplicationContext(ApplicationContext applicationContext);
}
