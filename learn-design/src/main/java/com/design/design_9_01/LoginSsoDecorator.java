package com.design.design_9_01;

import com.design.design_9_00.SsoInterceptor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 登录装饰器
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class LoginSsoDecorator extends SsoInterceptor {
  private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

  static {
    authMap.put("huahua", "queryUserInfo");
    authMap.put("doudou", "queryUserInfo");
  }

  @Override
  public boolean preHandle(String request, String response, Object handler) {
    // 模拟获取cookie
    String ticket = request.substring(1, 8);
    // 模拟校验
    boolean success = ticket.equals("success");
    if (!success) {
      return false;
    }
    String userId = request.substring(9);
    String method = authMap.get(userId);
    // 模拟方法校验
    return "queryUserInfo".equals(method);
  }
}
