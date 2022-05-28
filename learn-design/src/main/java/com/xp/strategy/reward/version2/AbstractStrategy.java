package com.xp.strategy.reward.version2;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/5/28
 */
public abstract class AbstractStrategy implements Strategy {
  public void register() {
    StrategyContext.registerStrategy(getClass().getSimpleName(), this);
  }
}
