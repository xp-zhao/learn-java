package org.learn.spring.context;

import java.util.EventListener;

/**
 * 事件监听器接口
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

  /**
   * 处理事件
   *
   * @param event
   */
  void onApplicationEvent(E event);
}
