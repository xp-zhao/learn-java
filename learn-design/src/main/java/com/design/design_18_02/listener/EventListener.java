package com.design.design_18_02.listener;

import com.design.design_18_02.LotteryResult;

/**
 * 事件监听
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public interface EventListener {
  /**
   * 事件通知
   *
   * @param result 结果
   */
  void doEvent(LotteryResult result);
}
