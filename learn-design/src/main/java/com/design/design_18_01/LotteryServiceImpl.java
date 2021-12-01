package com.design.design_18_01;

import com.design.design_18_00.MinibusTargetService;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

/**
 * 实现
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class LotteryServiceImpl implements LotteryService {

  private MinibusTargetService minibusTargetService = new MinibusTargetService();

  @Override
  public LotteryResult doDraw(String uId) {
    // 摇号
    String lottery = minibusTargetService.lottery(uId);
    // 发短信
    log.info("给用户 {} 发送短信通知(短信)：{}", uId, lottery);
    // 发MQ消息
    log.info("记录用户 {} 摇号结果(MQ)：{}", uId, lottery);
    // 结果
    return new LotteryResult(uId, lottery, new Date());
  }
}
