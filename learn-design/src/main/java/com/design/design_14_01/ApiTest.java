package com.design.design_14_01;

import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class ApiTest {
  @Test
  public void test() {
    // 广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
    XiaoEr xiaoEr = new XiaoEr();
    xiaoEr.order(1);
    xiaoEr.order(2);
    xiaoEr.order(3);
    xiaoEr.order(4);
    // 下单
    xiaoEr.placeOrder();
  }
}
