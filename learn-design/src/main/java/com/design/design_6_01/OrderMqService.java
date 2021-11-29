package com.design.design_6_01;

import com.alibaba.fastjson.JSON;
import com.design.design_6_00.mq.OrderMq;
import lombok.extern.slf4j.Slf4j;

/**
 * 订单消息处理
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Slf4j
public class OrderMqService {
  public void onMessage(String message) {

    OrderMq mq = JSON.parseObject(message, OrderMq.class);

    mq.getUid();
    mq.getOrderId();
    mq.getCreateOrderTime();

    // ... 处理自己的业务
    log.info("订单消息处理");
  }
}
