package com.xp.creator.factory.common.coupon;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 优惠券服务
 * @Date 2021-4-28
 **/
@Slf4j
public class CouponService {

  public CouponResult sendCoupon(String uId, String couponNumber, String uuid) {
    log.info("模拟发放优惠券一张：{}, {}, {}", uId, couponNumber, uuid);
    return new CouponResult("0000", "发放成功");
  }
}
