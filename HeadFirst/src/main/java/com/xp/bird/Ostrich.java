package com.xp.bird;

/**
 * @author zhaoxiaoping
 * @Description: 鸵鸟
 * @Date 2020/4/3
 **/
public class Ostrich implements Tweetable, EggLayable {
  
  private EggLayAbility eggLay = new EggLayAbility();
  private TweetAbility tweet = new TweetAbility(); 
  
  @Override
  public void layEgg() {
    eggLay.layEgg();
  }

  @Override
  public void tweet() {
    tweet.tweet();
  }
}
