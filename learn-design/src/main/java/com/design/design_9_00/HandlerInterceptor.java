package com.design.design_9_00;

/**
 * 拦截器
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public interface HandlerInterceptor {
  /**
   * 预处理
   *
   * @param request 请求
   * @param response 响应
   * @param handler 处理程序
   * @return boolean
   */
  boolean preHandle(String request, String response, Object handler);
}
