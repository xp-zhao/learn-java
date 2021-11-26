package com.xp.struct.adapter.v1;

import com.alibaba.fastjson.JSON;
import com.xp.struct.adapter.common.mq.OrderMq;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-4-30
 **/
@Slf4j
public class OrderMqService {

  public void onMessage(String message) {

    OrderMq mq = JSON.parseObject(message, OrderMq.class);

    log.info(mq.getUid());
    log.info(mq.getOrderId());
    log.info(mq.getCreateOrderTime().toString());

    // ... 处理自己的业务
  }
}
