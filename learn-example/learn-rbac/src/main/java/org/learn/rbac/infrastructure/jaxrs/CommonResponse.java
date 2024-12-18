package org.learn.rbac.infrastructure.jaxrs;

import java.util.function.Consumer;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Slf4j
public abstract class CommonResponse {

  /** 向客户端发送自定义操作信息 */
  public static Response send(Response.Status status, String message) {
    Integer code =
        status.getFamily() == Response.Status.Family.SUCCESSFUL
            ? CodedMessage.CODE_SUCCESS
            : CodedMessage.CODE_DEFAULT_FAILURE;
    return Response.status(status)
        .type(MediaType.APPLICATION_JSON)
        .entity(new CodedMessage(code, message))
        .build();
  }

  /** 向客户端发送操作失败的信息 */
  public static Response failure(String message) {
    return send(Response.Status.INTERNAL_SERVER_ERROR, message);
  }

  /** 向客户端发送操作成功的信息 */
  public static Response success(String message) {
    return send(Response.Status.OK, message);
  }

  /** 向客户端发送操作成功的信息 */
  public static Response success() {
    return send(Response.Status.OK, "操作已成功");
  }

  /** 执行操作，并根据操作是否成功返回给客户端相应信息 封装了在服务端接口中很常见的执行操作，成功返回成功标志、失败返回失败标志的通用操作，用于简化编码 */
  public static Response op(Runnable executor) {
    return op(executor, e -> log.error(e.getMessage(), e));
  }

  /** 执行操作（带自定义的失败处理），并根据操作是否成功返回给客户端相应信息 封装了在服务端接口中很常见的执行操作，成功返回成功标志、失败返回失败标志的通用操作，用于简化编码 */
  public static Response op(Runnable executor, Consumer<Exception> exceptionConsumer) {
    try {
      executor.run();
      return CommonResponse.success();
    } catch (Exception e) {
      exceptionConsumer.accept(e);
      return CommonResponse.failure(e.getMessage());
    }
  }
}
