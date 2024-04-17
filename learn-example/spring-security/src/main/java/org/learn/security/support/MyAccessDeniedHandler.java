package org.learn.security.support;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * 自定义没有权限时的返回信息
 *
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
@Slf4j
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
  @Override
  public void handle(
      HttpServletRequest request,
      HttpServletResponse response,
      AccessDeniedException accessDeniedException)
      throws IOException, ServletException {
    log.error("access error", accessDeniedException);
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    response.getWriter().println("禁止访问");
    response.getWriter().flush();
  }
}
