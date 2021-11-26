package com.xp.bird;

/**
 * @author lenovo
 */
public interface EggLayable {

  /**
   * 下蛋
   */
  void layEgg();

  /**
   * 接口默认方法测试
   */
  default void test() {
    System.out.println("test");
  }
}
