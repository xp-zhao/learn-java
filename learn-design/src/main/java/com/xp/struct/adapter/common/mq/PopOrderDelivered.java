package com.xp.struct.adapter.common.mq;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-4-30
 **/
@Data
public class PopOrderDelivered {

  private String uId;
  private String orderId;
  private LocalDateTime orderTime;
  private String sku;
  private String skuName;
  private BigDecimal decimal;
}
