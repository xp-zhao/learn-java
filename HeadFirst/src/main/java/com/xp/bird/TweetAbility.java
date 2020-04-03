package com.xp.bird;

/**
 * @author zhaoxiaoping
 * @Description: 叫声默认实现
 * @Date 2020/4/3
 **/
public class TweetAbility implements Tweetable {

  @Override
  public void tweet() {
    System.out.println("叫声");
  }
}
