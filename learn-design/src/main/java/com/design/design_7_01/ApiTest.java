package com.design.design_7_01;

import java.math.BigDecimal;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class ApiTest {
  @Test
  public void testPay() {
    PayController pay = new PayController();

    System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
    pay.doPay("weixin_1092033111", "100000109893", new BigDecimal(100), 1, 2);

    System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
    pay.doPay("jlu19dlxo111","100000109894",new BigDecimal(100), 2, 3);
  }
}
