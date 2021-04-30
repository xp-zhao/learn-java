package com.xp.struct.adapter.v2;

import com.xp.struct.adapter.common.service.PopOrderService;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-4-30
 **/
public class PopOrderAdapterServiceImpl implements OrderAdapterService {

  private PopOrderService popOrderService = new PopOrderService();

  @Override
  public boolean isFirst(String uId) {
    return popOrderService.isFirstOrder(uId);
  }
}
