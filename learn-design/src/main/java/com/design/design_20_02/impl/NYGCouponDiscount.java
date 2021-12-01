package com.design.design_20_02.impl;

import com.design.design_20_02.ICouponDiscount;
import java.math.BigDecimal;

/**
 * n 元购买
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class NYGCouponDiscount implements ICouponDiscount<Double> {

  /** n元购购买, 无论原价多少钱都固定金额购买 */
  @Override
  public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
    return new BigDecimal(couponInfo);
  }
}
