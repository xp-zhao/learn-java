package org.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.test.context.junit4.SpringRunner;
import org.statemachine.enums.OrderEvent;
import org.statemachine.enums.OrderState;
import org.statemachine.util.StateEventUtil;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StateMachineApplication.class)
public class AppTest {
  @Autowired private StateMachine<OrderState, OrderEvent> stateMachine;
  @Autowired private StateEventUtil stateEventUtil;

  @Test
  public void testStateMachine() {
    stateMachine.start();
    log.info("当前状态：{}", stateMachine.getState().getId());
    Message<OrderEvent> message =
        MessageBuilder.withPayload(OrderEvent.PAY).setHeader("order", "订单对象").build();
    stateMachine.sendEvent(message);
  }

  @Test
  public void testStateEventUtil() {
    Message<OrderEvent> message =
        MessageBuilder.withPayload(OrderEvent.PAY).setHeader("order", "订单对象").build();
    stateEventUtil.sendEvent(message);
  }
}
