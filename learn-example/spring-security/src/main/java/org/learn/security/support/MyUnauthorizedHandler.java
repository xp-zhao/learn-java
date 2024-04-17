package org.learn.security.support;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * 自定义没有登录时的返回
 *
 * @author zhaoxiaoping
 * @date 2024-4-17
 */
@Slf4j
@Component
public class MyUnauthorizedHandler implements AuthenticationEntryPoint {
  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException)
      throws IOException, ServletException {
    log.error("Unauthorized error", authException);
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json");
    response.getWriter().println("认证失败");
    response.getWriter().flush();
  }
}
