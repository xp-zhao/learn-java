package com.xp.struct.bridge.v2.channel;

import com.xp.struct.bridge.v2.mode.IPayMode;
import java.math.BigDecimal;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 支付渠道
 * @Date 2021-4-30
 **/
@Slf4j
public abstract class Pay {

  protected IPayMode payMode;

  public Pay(IPayMode payMode) {
    this.payMode = payMode;
  }

  /**
   * 转账操作
   *
   * @param uId
   * @param tradeId
   * @param amount
   * @return
   */
  public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
