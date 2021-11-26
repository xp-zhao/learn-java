package com.xp.struct.adapter.common.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 订单服务
 * @Date 2021-4-30
 **/
@Slf4j
public class OrderService {

  public long queryUserOrderCount(String userId) {
    log.info("自营商家，查询用户的订单是否为首单：{}", userId);
    return 10L;
  }
}
