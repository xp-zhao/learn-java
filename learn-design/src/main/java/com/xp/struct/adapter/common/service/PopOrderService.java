package com.xp.struct.adapter.common.service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-4-30
 **/
@Slf4j
public class PopOrderService {

  public boolean isFirstOrder(String uId) {
    log.info("POP商家，查询用户的订单是否为首单：{}", uId);
    return true;
  }
}
