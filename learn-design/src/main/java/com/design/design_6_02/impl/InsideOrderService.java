package com.design.design_6_02.impl;

import com.design.design_6_00.service.OrderService;
import com.design.design_6_02.OrderAdapterService;

/**
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class InsideOrderService implements OrderAdapterService {

  private OrderService orderService = new OrderService();

  @Override
  public boolean isFirst(String uId) {
    return orderService.queryUserOrderCount(uId) <= 1;
  }
}
