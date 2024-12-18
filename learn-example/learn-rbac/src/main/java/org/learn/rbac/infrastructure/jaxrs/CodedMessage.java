package org.learn.rbac.infrastructure.jaxrs;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 用于返回给客户端以形式为“{code,message,data}”的对象格式
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CodedMessage {
  /** 约定的成功标志 */
  public static final Integer CODE_SUCCESS = 0;

  /** 默认的失败标志，其他失败含义可以自定义 */
  public static final Integer CODE_DEFAULT_FAILURE = 1;

  private Integer code;
  private String message;
  private Object data;

  public CodedMessage(Integer code, String message) {
    setCode(code);
    setMessage(message);
  }
}
