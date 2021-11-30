package com.design.design_9_02;

import com.design.design_9_00.HandlerInterceptor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;

/**
 * 登录装饰器
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class LoginSsoDecorator extends SsoDecorator {
  private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

  static {
    authMap.put("huahua", "queryUserInfo");
    authMap.put("doudou", "queryUserInfo");
  }

  public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
    super(handlerInterceptor);
  }

  @Override
  public boolean preHandle(String request, String response, Object handler) {
    boolean success = super.preHandle(request, response, handler);
    if (!success) {
      return false;
    }
    String userId = request.substring(8);
    String method = authMap.get(userId);
    log.info("模拟单点登录方法访问拦截校验：{} {}", userId, method);
    // 模拟方法校验
    return "queryUserInfo".equals(method);
  }
}
