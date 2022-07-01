package java.org.learn.spring.context;

import java.util.EventListener;

/**
 * 监听器接口
 *
 * @author zhaoxiaoping
 * @date 2022-1-6
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
  /**
   * 应用程序事件
   *
   * @param event 事件
   */
  void onApplicationEvent(E event);
}
