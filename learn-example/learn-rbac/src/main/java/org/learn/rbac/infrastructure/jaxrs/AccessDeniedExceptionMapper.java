package org.learn.rbac.infrastructure.jaxrs;

import java.nio.file.AccessDeniedException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于统一处理在Resource中由于Spring Security授权访问产生的异常信息
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Slf4j
@Provider
public class AccessDeniedExceptionMapper implements ExceptionMapper<AccessDeniedException> {
  @Context private HttpServletRequest request;

  @Override
  public Response toResponse(AccessDeniedException e) {
    log.warn("越权访问被禁止 {}: {}", request.getMethod(), request.getPathInfo());
    return CommonResponse.send(Response.Status.FORBIDDEN, e.getMessage());
  }
}
