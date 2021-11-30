package com.design.design_11_02;

import com.design.design_11_01.Activity;
import com.design.design_11_01.Stock;
import com.design.design_11_02.util.RedisUtils;

/**
 * 控制层
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class ActivityController {
  private RedisUtils redisUtils = new RedisUtils();

  public Activity queryActivityInfo(Long id) {
    Activity activity = ActivityFactory.getActivity(id);
    // 模拟从Redis中获取库存变化信息
    Stock stock = new Stock(1000, redisUtils.getStockUsed());
    activity.setStock(stock);
    return activity;
  }
}
