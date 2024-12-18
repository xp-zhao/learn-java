package org.learn.rbac.infrastructure.jaxrs;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于兜底的全局处理器，如果其他所有的Mapper都不合适，将由此处理把错误带到前端
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Slf4j
@Produces
public class BaseExceptionMapper implements ExceptionMapper<Throwable> {
  @Override
  public Response toResponse(Throwable throwable) {
    log.error(throwable.getMessage(), throwable);
    return CommonResponse.failure(throwable.getMessage());
  }
}
