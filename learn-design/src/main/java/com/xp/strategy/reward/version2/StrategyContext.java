package com.xp.strategy.reward.version2;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/5/28
 */
public class StrategyContext {

  private static final Map<String, Strategy> registerMap = new HashMap<>();

  public static void registerStrategy(String rewardType, Strategy strategy) {
    registerMap.putIfAbsent(rewardType, strategy);
  }

  public static Strategy getStrategy(String rewardType) {
    return registerMap.get(rewardType);
  }
}
