package com.xp.bird;

/**
 * @author zhaoxiaoping
 * @Description: 麻雀
 * @Date 2020/4/3
 **/
public class Sparrow implements Flyable, EggLayable, Tweetable {

  private EggLayAbility eggLay = new EggLayAbility();
  private TweetAbility tweet = new TweetAbility();
  private FlyAbility fly = new FlyAbility();

  @Override
  public void layEgg() {
    eggLay.layEgg();
  }

  @Override
  public void fly() {
    fly.fly();
  }

  @Override
  public void tweet() {
    tweet.tweet();
  }

  public static void main(String[] args) {
    Sparrow s = new Sparrow();
    s.fly();
    s.tweet();
    s.layEgg();
    s.test();
  }
}
