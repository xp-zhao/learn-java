package org.statemachine.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;
import org.statemachine.enums.OrderEvent;

@Slf4j
@Component
@WithStateMachine(name = "orderStateMachine")
public class OrderStatusListener {
  @OnTransition(source = "CREATED", target = "PAID")
  public boolean payTransition(Message<OrderEvent> message) {
    log.info("订单支付确认，状态机信息：{}", message.getHeaders());
    return true;
  }
}
