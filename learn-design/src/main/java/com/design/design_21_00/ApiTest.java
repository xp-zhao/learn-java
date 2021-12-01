package com.design.design_21_00;

import com.design.design_21_00.impl.JDNetMall;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
@Slf4j
public class ApiTest {
  @Test
  public void testNetMall() {
    NetMall netMall = new JDNetMall("1000001", "*******");
    String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
    log.info("测试结果：{}", base64);
  }
}
