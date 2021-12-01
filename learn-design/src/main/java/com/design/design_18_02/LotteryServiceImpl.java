package com.design.design_18_02;

import com.design.design_18_00.MinibusTargetService;
import java.util.Date;

/**
 * 抽奖实现
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class LotteryServiceImpl extends LotteryService {

  private MinibusTargetService minibusTargetService = new MinibusTargetService();

  @Override
  protected LotteryResult doDraw(String uId) {
    // 摇号
    String lottery = minibusTargetService.lottery(uId);
    // 结果
    return new LotteryResult(uId, lottery, new Date());
  }
}
