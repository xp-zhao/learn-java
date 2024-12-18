package org.learn.rbac.infrastructure.jaxrs;

import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

/**
 * 用于统一处理在Resource中由于验证器验证失败而带回客户端的错误信息
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Slf4j
@Provider
public class ViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {
  @Override
  public Response toResponse(ConstraintViolationException e) {
    log.warn("客户端传入了校验结果为非法的数据", e);
    String msg =
        e.getConstraintViolations().stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.joining("；"));
    return CommonResponse.send(Response.Status.BAD_REQUEST, msg);
  }
}
