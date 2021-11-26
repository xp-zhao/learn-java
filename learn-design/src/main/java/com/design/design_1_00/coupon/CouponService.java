package com.design.design_1_00.coupon;

import lombok.extern.slf4j.Slf4j;

/**
 * 模拟优惠券服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Slf4j
public class CouponService {
  public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
    log.info("模拟发放优惠券一张： {}, {}, {}", uId, couponNumber, uuid);
    return new CouponResult("0000", "发放成功");
  }
}
