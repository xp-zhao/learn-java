package com.design.design_7_02;

import com.design.design_7_02.channel.AliPay;
import com.design.design_7_02.channel.Pay;
import com.design.design_7_02.channel.WxPay;
import com.design.design_7_02.mode.PayFaceMode;
import com.design.design_7_02.mode.PayFingerprintMode;
import java.math.BigDecimal;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class ApiTest {
  @Test
  public void testPay() {
    System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
    Pay wxPay = new WxPay(new PayFaceMode());
    wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

    System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
    Pay aliPay = new AliPay(new PayFingerprintMode());
    aliPay.transfer("jlu19dlxo111", "100000109894", new BigDecimal(100));
  }
}
