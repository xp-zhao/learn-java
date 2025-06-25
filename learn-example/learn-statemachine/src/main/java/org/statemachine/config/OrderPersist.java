package org.statemachine.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.statemachine.enums.OrderEvent;
import org.statemachine.enums.OrderState;

/** 持久化配置 */
@Configuration
public class OrderPersist {
  /**
   * 持久化配置，这里使用内存存储，实际使用中可以使用数据库或者 redis 存储
   *
   * @return
   */
  @Bean
  public DefaultStateMachinePersister<OrderState, OrderEvent, String> stateMachinePersister() {
    Map<String, StateMachineContext<OrderState, OrderEvent>> map = new HashMap<>();
    return new DefaultStateMachinePersister<>(
        new StateMachinePersist<OrderState, OrderEvent, String>() {
          @Override
          public void write(
              StateMachineContext<OrderState, OrderEvent> stateMachineContext, String s)
              throws Exception {
            // 持久化操作
            map.put(s, stateMachineContext);
          }

          @Override
          public StateMachineContext<OrderState, OrderEvent> read(String s) throws Exception {
            // 从持久化中读取数据
            return map.get(s);
          }
        });
  }
}
