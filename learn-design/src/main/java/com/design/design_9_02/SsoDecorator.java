package com.design.design_9_02;

import com.design.design_9_00.HandlerInterceptor;

/**
 * 单点登录装饰器
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public abstract class SsoDecorator implements HandlerInterceptor {
  private HandlerInterceptor handlerInterceptor;

  public SsoDecorator() {}

  public SsoDecorator(HandlerInterceptor handlerInterceptor) {
    this.handlerInterceptor = handlerInterceptor;
  }

  @Override
  public boolean preHandle(String request, String response, Object handler) {
    return handlerInterceptor.preHandle(request, response, handler);
  }
}
