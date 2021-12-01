package com.design.design_18_02.listener;

import com.design.design_18_02.LotteryResult;
import lombok.extern.slf4j.Slf4j;

/**
 * mq 消息发送事件
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class MQEventListener implements EventListener {

  @Override
  public void doEvent(LotteryResult result) {
    log.info("记录用户 {} 摇号结果(MQ)：{}", result.getUId(), result.getMsg());
  }
}
