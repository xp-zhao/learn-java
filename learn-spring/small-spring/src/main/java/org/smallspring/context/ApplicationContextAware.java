package org.smallspring.context;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.Aware;

/**
 * Application感知接口，实现此接口，既能感知到所属的 ApplicationContext
 *
 * @author xp-zhao
 * @date 2022/1/5
 */
public interface ApplicationContextAware extends Aware {
  /**
   * 设置应用程序上下文
   *
   * @param applicationContext 应用程序上下文
   * @throws BeansException 异常
   */
  void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
