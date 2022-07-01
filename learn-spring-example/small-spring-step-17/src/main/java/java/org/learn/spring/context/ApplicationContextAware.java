package java.org.learn.spring.context;

import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.Aware;

/**
 * 所属 ApplicationContext 感知接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
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
