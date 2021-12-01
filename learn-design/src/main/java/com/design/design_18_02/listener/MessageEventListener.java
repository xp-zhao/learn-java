package com.design.design_18_02.listener;

import com.design.design_18_02.LotteryResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 短信发送事件
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class MessageEventListener implements EventListener {

  @Override
  public void doEvent(LotteryResult result) {
    log.info("给用户 {} 发送短信通知(短信)：{}", result.getUId(), result.getMsg());
  }
}
