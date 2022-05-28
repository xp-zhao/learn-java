package com.xp.strategy.reward.version2;

import com.xp.strategy.reward.HotelRequest;
import com.xp.strategy.reward.HotelService;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/5/28
 */
class Hotel extends AbstractStrategy implements Strategy {
  private HotelService hotelService;
  private static final Hotel instance = new Hotel();

  private Hotel() {
    register();
  }

  public static Hotel getInstance() {
    return instance;
  }

  @Override
  public void issue(Object... params) {
    HotelRequest request = new HotelRequest();
    request.addHotelReq(params);
    hotelService.sendPrize(request);
  }
}
