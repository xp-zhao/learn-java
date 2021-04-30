package com.xp.struct.adapter.v2;

import com.xp.struct.adapter.common.service.OrderService;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-4-30
 **/
public class InsideOrderServiceImpl implements OrderAdapterService {

  private OrderService orderService = new OrderService();


  @Override
  public boolean isFirst(String uId) {
    return orderService.queryUserOrderCount(uId) <= 1;
  }
}
