package com.design.design_20_02.impl;

import com.design.design_20_02.ICouponDiscount;
import java.math.BigDecimal;

/**
 * 直减
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

  /**
   * 直减计算<br>
   * 1. 使用商品价格减去优惠价格<br>
   * 2. 最低支付金额1元
   */
  @Override
  public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
    BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
    if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
      return BigDecimal.ONE;
    }
    return discountAmount;
  }
}
