package org.statemachine.enums;

public enum OrderState {
  /** 创建订单 */
  CREATED,
  /** 支付订单 */
  PAID,
  /** 发货 */
  SHIPPED,
  /** 确认收货 */
  DELIVERED,
  /** 取消订单 */
  CANCELED,
  /** 退款 */
  REFUNDED
}
