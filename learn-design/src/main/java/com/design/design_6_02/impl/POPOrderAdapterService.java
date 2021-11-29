package com.design.design_6_02.impl;

import com.design.design_6_00.service.POPOrderService;
import com.design.design_6_02.OrderAdapterService;

/**
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class POPOrderAdapterService implements OrderAdapterService {

  private POPOrderService popOrderService = new POPOrderService();

  @Override
  public boolean isFirst(String uId) {
    return popOrderService.isFirstOrder(uId);
  }
}
