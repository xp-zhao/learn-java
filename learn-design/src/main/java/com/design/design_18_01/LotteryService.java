package com.design.design_18_01;

/**
 * 摇号服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public interface LotteryService {
  /**
   * 摇号
   *
   * @param uId 用户id
   * @return {@code LotteryResult}
   */
  LotteryResult doDraw(String uId);
}
