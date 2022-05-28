package com.xp.strategy.reward.version2;

import com.xp.strategy.reward.WaimaiRequest;
import com.xp.strategy.reward.WaimaiService;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/5/28
 */
class Waimai extends AbstractStrategy implements Strategy {
  private WaimaiService waimaiService;
  private static final Waimai instance = new Waimai();

  private Waimai() {
    register();
  }

  public static Waimai getInstance() {
    return instance;
  }

  @Override
  public void issue(Object... params) {
    WaimaiRequest request = new WaimaiRequest();
    // 构建入参
    request.setWaimaiReq(params);
    waimaiService.issueWaimai(request);
  }
}
