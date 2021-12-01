package com.design.design_18_02;

import com.design.design_18_02.listener.MQEventListener;
import com.design.design_18_02.listener.MessageEventListener;

/**
 * 抽奖服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public abstract class LotteryService {
  private EventManager eventManager;

  public LotteryService() {
    eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
    eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
    eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
  }

  public LotteryResult draw(String uId) {
    LotteryResult lotteryResult = doDraw(uId);
    // 需要什么通知就给调用什么方法
    eventManager.notify(EventManager.EventType.MQ, lotteryResult);
    eventManager.notify(EventManager.EventType.Message, lotteryResult);
    return lotteryResult;
  }

  /**
   * 抽奖
   *
   * @param uId 你的id
   * @return {@code LotteryResult}
   */
  protected abstract LotteryResult doDraw(String uId);
}
