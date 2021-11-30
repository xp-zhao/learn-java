package com.design.design_9_01;

import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class ApiTest {
  @Test
  public void testSso() {
    LoginSsoDecorator ssoInterceptor = new LoginSsoDecorator();
    String request = "1successhuahua";
    boolean success = ssoInterceptor.preHandle(request, "ewcdqwt40liuiu", "t");
    System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
  }
}
