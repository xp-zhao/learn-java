package java.org.learn.spring.context;

import org.learn.spring.beans.BeansException;

/**
 * @author zhaoxiaoping
 * @date 2022-1-5
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
  /**
   * 刷新容器
   *
   * @throws BeansException 异常
   */
  void refresh() throws BeansException;

  /** 注册关闭钩子 */
  void registerShutdownHook();

  /** 手动关闭方法 */
  void close();
}
