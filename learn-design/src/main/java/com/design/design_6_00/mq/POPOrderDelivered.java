package com.design.design_6_00.mq;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
public class POPOrderDelivered {
  /** 用户ID */
  private String uId;

  /** 订单号 */
  private String orderId;

  /** 下单时间 */
  private Date orderTime;

  /** 商品 */
  private Date sku;

  /** 商品名称 */
  private Date skuName;

  /** 金额 */
  private BigDecimal decimal;
}
