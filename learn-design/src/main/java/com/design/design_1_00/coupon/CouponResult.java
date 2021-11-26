package com.design.design_1_00.coupon;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回对象
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Data
@AllArgsConstructor
public class CouponResult {

  /** 编码 */
  private String code;
  /** 描述 */
  private String info;
}
