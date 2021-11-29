package com.design.design_7_02.channel;

import com.design.design_7_02.mode.IPayMode;
import java.math.BigDecimal;

/**
 * 支付
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public abstract class Pay {
  protected IPayMode payMode;

  public Pay(IPayMode payMode) {
    this.payMode = payMode;
  }

  /**
   * 转账
   *
   * @param uId 用户id
   * @param tradeId 交易id
   * @param amount 数量
   * @return {@code String}
   */
  public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
