package org.statemachine.config;

import java.util.EnumSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.guard.Guard;
import org.springframework.statemachine.state.State;
import org.statemachine.enums.OrderEvent;
import org.statemachine.enums.OrderState;

@Slf4j
@Configuration
@EnableStateMachine(name = "orderStateMachine")
public class OrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderState, OrderEvent> {
  /**
   * 配置状态机的状态
   *
   * @param config 状态机配置器
   * @throws Exception 配置异常
   */
  @Override
  public void configure(StateMachineStateConfigurer<OrderState, OrderEvent> config)
      throws Exception {
    config.withStates().initial(OrderState.CREATED).states(EnumSet.allOf(OrderState.class));
  }

  /**
   * 配置状态机的转换
   *
   * @param config 状态机配置器
   * @throws Exception 配置异常
   */
  @Override
  public void configure(StateMachineTransitionConfigurer<OrderState, OrderEvent> config)
      throws Exception {
    config
        .withExternal()
        .source(OrderState.CREATED)
        .target(OrderState.PAID)
        .event(OrderEvent.PAY)
        .action(payAction())
        .guard(guard())
        .and()
        .withExternal()
        .state(OrderState.PAID)
        .target(OrderState.SHIPPED)
        .event(OrderEvent.SHIP)
        .action(shipAction())
        .and()
        .withExternal()
        .source(OrderState.SHIPPED)
        .target(OrderState.DELIVERED)
        .event(OrderEvent.DELIVER)
        .action(deliveredAction())
        .and()
        .withExternal()
        .source(OrderState.CREATED)
        .target(OrderState.CANCELED)
        .event(OrderEvent.CANCEL)
        .action(cancelAction())
        .and()
        .withExternal()
        .source(OrderState.PAID)
        .target(OrderState.REFUNDED)
        .event(OrderEvent.REFUND)
        .action(refundAction());
  }

  /**
   * 配置状态机的操作
   *
   * @return 操作
   */
  @Bean
  public Action<OrderState, OrderEvent> payAction() {
    return (context) -> {
      // 执行支付操作逻辑
      log.info("payAction");
    };
  }

  /**
   * 配置状态机的操作
   *
   * @return 操作
   */
  @Bean
  public Action<OrderState, OrderEvent> shipAction() {
    return (context) -> {
      // 执行发货操作逻辑
      log.info("shipAction");
    };
  }

  /**
   * 配置状态机的操作
   *
   * @return 操作
   */
  @Bean
  public Action<OrderState, OrderEvent> deliveredAction() {
    return (context) -> {
      // 执行收货操作逻辑
      log.info("deliveredAction");
    };
  }

  /**
   * 配置状态机的操作
   *
   * @return 操作
   */
  @Bean
  public Action<OrderState, OrderEvent> cancelAction() {
    return (context) -> {
      // 执行取消支付操作逻辑
      log.info("cancelAction");
    };
  }

  /**
   * 配置状态机的操作
   *
   * @return 操作
   */
  @Bean
  public Action<OrderState, OrderEvent> refundAction() {
    return (context) -> {
      // 执行退款操作逻辑
      log.info("refundAction");
    };
  }

  /**
   * 配置状态机的操作校验
   *
   * @return 校验
   */
  @Bean
  public Guard<OrderState, OrderEvent> guard() {
    return (context) -> {
      // 执行操作校验逻辑
      return true;
    };
  }

  /**
   * 状态发生变化时触发
   *
   * @param from 源状态
   * @param to 目标状态
   */
  public void stateChanged(State<OrderState, OrderEvent> from, State<OrderState, OrderEvent> to) {
    // 状态发生变化时触发
    log.info("状态从 {} 转换到 {}", from.getId(), to.getId());
  }
}
