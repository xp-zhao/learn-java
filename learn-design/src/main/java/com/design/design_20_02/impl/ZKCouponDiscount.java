package com.design.design_20_02.impl;

import com.design.design_20_02.ICouponDiscount;
import java.math.BigDecimal;

/**
 * 折扣
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class ZKCouponDiscount implements ICouponDiscount<Double> {

  /**
   * 折扣计算<br>
   * 1. 使用商品价格乘以折扣比例，为最后支付金额<br>
   * 2. 保留两位小数<br>
   * 3. 最低支付金额1元<br>
   */
  @Override
  public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
    BigDecimal discountAmount =
        skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);
    if (discountAmount.compareTo(BigDecimal.ZERO) < 1) {
      return BigDecimal.ONE;
    }
    return discountAmount;
  }
}
