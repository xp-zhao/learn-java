package com.xp.bird;

/**
 * @author zhaoxiaoping
 * @Description: 飞行能力实现
 * @Date 2020/4/3
 **/
public class FlyAbility implements Flyable {

  @Override
  public void fly() {
    System.out.println("飞行能力");
  }
}
