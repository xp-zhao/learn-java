package com.xp.strategy.reward.version2;

import com.xp.strategy.reward.FoodRequest;
import com.xp.strategy.reward.FoodService;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/5/28
 */
class Food extends AbstractStrategy implements Strategy {
  private FoodService foodService;
  private static final Food instance = new Food();

  private Food() {
    register();
  }

  public static Food getInstance() {
    return instance;
  }

  @Override
  public void issue(Object... params) {
    FoodRequest request = new FoodRequest(params);
    foodService.payCoupon(request);
  }
}
