package com.xp.struct.adapter.common.mq;

import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: 订单消息
 * @Date 2021-4-30
 **/
@Data
public class OrderMq {

  private String uid;
  private String sku;
  private String orderId;
  private LocalDateTime createOrderTime;
}
