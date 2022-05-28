package com.xp.strategy.reward.version2;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/5/28
 */
public class RewardService {
  public void issueReward(String rewardType, Object... params) {
    Strategy strategy = StrategyContext.getStrategy(rewardType);
    strategy.issue(params);
  }

  public static void main(String[] args) {
    RewardService rewardService = new RewardService();
    Food food = Food.getInstance();
    rewardService.issueReward("");
  }
}
