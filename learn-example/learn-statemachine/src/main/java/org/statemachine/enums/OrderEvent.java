package org.statemachine.enums;

public enum OrderEvent {
  /** 支付 */
  PAY,
  /** 发货 */
  SHIP,
  /** 收货 */
  DELIVER,
  /** 取消订单 */
  CANCEL,
  /** 退款 */
  REFUND
}
