package com.design.design_18_02;

import com.design.design_18_02.listener.EventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件管理器
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class EventManager {
  Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

  public EventManager(Enum<EventType>... operations) {
    for (Enum<EventType> operation : operations) {
      this.listeners.put(operation, new ArrayList<>());
    }
  }

  /**
   * 订阅
   *
   * @param eventType 事件类型
   * @param listener 监听
   */
  public void subscribe(Enum<EventType> eventType, EventListener listener) {
    List<EventListener> users = listeners.get(eventType);
    users.add(listener);
  }

  /**
   * 取消订阅
   *
   * @param eventType 事件类型
   * @param listener 监听
   */
  public void unsubscribe(Enum<EventType> eventType, EventListener listener) {
    List<EventListener> users = listeners.get(eventType);
    users.remove(listener);
  }

  /**
   * 通知
   *
   * @param eventType 事件类型
   * @param result 结果
   */
  public void notify(Enum<EventType> eventType, LotteryResult result) {
    List<EventListener> users = listeners.get(eventType);
    for (EventListener listener : users) {
      listener.doEvent(result);
    }
  }

  public enum EventType {
    /** mq 类型 */
    MQ,
    /** 短信类型 */
    Message
  }
}
