package com.xp.creator.factory.v2.store.impl;

import com.alibaba.fastjson.JSON;
import com.xp.creator.factory.common.coupon.CouponResult;
import com.xp.creator.factory.common.coupon.CouponService;
import com.xp.creator.factory.v2.store.ICommodity;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 优惠券服务
 * @Date 2021-4-28
 **/
@Slf4j
public class CouponCommodityService implements ICommodity {

  private CouponService couponService = new CouponService();

  @Override
  public void sendCommodity(String uId, String commodityId, String bizId,
      Map<String, String> extMap) throws Exception {
    CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
    log.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON
        .toJSON(extMap));
    log.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
    if (!"0000".equals(couponResult.getCode())) {
      throw new RuntimeException(couponResult.getInfo());
    }
  }
}
