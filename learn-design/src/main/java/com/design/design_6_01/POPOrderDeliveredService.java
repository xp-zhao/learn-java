package com.design.design_6_01;

import com.alibaba.fastjson.JSON;
import com.design.design_6_00.mq.POPOrderDelivered;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Slf4j
public class POPOrderDeliveredService {
  public void onMessage(String message) {

    POPOrderDelivered mq = JSON.parseObject(message, POPOrderDelivered.class);

    mq.getUId();
    mq.getOrderId();
    mq.getOrderTime();

    log.info("pop 订单消息处理");
  }
}
