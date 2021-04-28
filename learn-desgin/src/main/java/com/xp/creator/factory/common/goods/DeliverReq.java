package com.xp.creator.factory.common.goods;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: 实物发放请求对象
 * @Date 2021-4-28
 **/
@Data
public class DeliverReq {

  private String userName;
  private String userPhone;
  private String sku;
  private String orderId;
  private String consigneeUserName;
  private String consigneeUserPhone;
  private String consigneeUserAddress;
}
