package com.design.design_6_00.mq;

import java.util.Date;
import lombok.Data;

/**
 * 下单
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
public class OrderMq {
  /** 用户ID */
  private String uid;

  /** 商品 */
  private String sku;

  /** 订单ID */
  private String orderId;

  /** 下单时间 */
  private Date createOrderTime;
}
