package com.design.design_9_00;

/**
 * sso 拦截
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class SsoInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(String request, String response, Object handler) {
    // 模拟获取cookie
    String ticket = request.substring(1, 8);
    // 模拟校验
    return ticket.equals("success");
  }
}
