package com.design.design_20_02;

import java.math.BigDecimal;

/**
 * 策略控制类
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class Context<T> {
  private ICouponDiscount<T> couponDiscount;

  public Context(ICouponDiscount<T> couponDiscount) {
    this.couponDiscount = couponDiscount;
  }

  public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
    return couponDiscount.discountAmount(couponInfo, skuPrice);
  }
}
