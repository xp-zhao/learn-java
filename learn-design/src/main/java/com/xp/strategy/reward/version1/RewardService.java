package com.xp.strategy.reward.version1;

import com.xp.strategy.reward.*;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/5/28
 */
public class RewardService {
  private WaimaiService waimaiService;
  private FoodService foodService;
  private HotelService hotelService;

  public void issueReward(String rewardType, Object... params) {
    if ("Waimai".equals(rewardType)) {
      WaimaiRequest request = new WaimaiRequest();
      // 构建入参
      request.setWaimaiReq(params);
      waimaiService.issueWaimai(request);
    } else if ("Hotel".equals(rewardType)) {
      HotelRequest request = new HotelRequest();
      request.addHotelReq(params);
      hotelService.sendPrize(request);
    } else if ("Food".equals(rewardType)) {
      FoodRequest request = new FoodRequest(params);
      foodService.getCoupon(request);
    } else {
      throw new IllegalArgumentException("rewardType error!");
    }
  }
}
