package com.xp.struct.adapter.v1;

import com.alibaba.fastjson.JSON;
import com.xp.struct.adapter.common.mq.PopOrderDelivered;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-4-30
 **/
@Slf4j
public class PopOrderDeliveredService {

  public void onMessage(String message) {

    PopOrderDelivered mq = JSON.parseObject(message, PopOrderDelivered.class);

    log.info(mq.getUId());
    log.info(mq.getOrderId());
    log.info(mq.getOrderTime().toString());

    // ... 处理自己的业务
  }
}
