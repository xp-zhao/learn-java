package com.xp.creator.factory.common.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoxiaoping
 * @Description: 优惠券发放结果
 * @Date 2021-4-28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponResult {

  /**
   * 编码
   */
  private String code;
  /**
   * 描述
   */
  private String info;
}
