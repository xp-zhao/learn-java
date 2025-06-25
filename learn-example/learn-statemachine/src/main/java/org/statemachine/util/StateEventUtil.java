package org.statemachine.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Component;
import org.statemachine.enums.OrderEvent;
import org.statemachine.enums.OrderState;

@Component
public class StateEventUtil {
  private StateMachine<OrderState, OrderEvent> orderStateMachine;

  private StateMachinePersister<OrderState, OrderEvent, String> stateMachinePersister;

  /**
   * 发送状态转换事件
   *
   * @param message
   * @return
   */
  public synchronized boolean sendEvent(Message<OrderEvent> message) {
    boolean result = false;
    try {
      // 启动状态机
      orderStateMachine.start();
      String orderId = "orderId";
      // 恢复状态机状态
      stateMachinePersister.restore(orderStateMachine, orderId);
      result = orderStateMachine.sendEvent(message);
      // 持久化状态机状态
      stateMachinePersister.persist(orderStateMachine, orderId);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (orderStateMachine != null) {
        orderStateMachine.stop();
      }
    }
    return result;
  }

  @Autowired
  public void setOrderStateMachine(StateMachine<OrderState, OrderEvent> orderStateMachine) {
    this.orderStateMachine = orderStateMachine;
  }

  @Autowired
  public void setStateMachinePersister(
      StateMachinePersister<OrderState, OrderEvent, String> stateMachinePersister) {
    this.stateMachinePersister = stateMachinePersister;
  }
}
