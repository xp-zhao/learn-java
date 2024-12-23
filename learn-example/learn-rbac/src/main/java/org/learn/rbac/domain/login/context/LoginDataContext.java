package org.learn.rbac.domain.login.context;

import lombok.Data;
import org.learn.rbac.domain.login.request.ILoginRequest;

/**
 * 登录上下文
 *
 * @author zhaoxiaoping
 * @date 2024-12-23
 */
@Data
public class LoginDataContext {
  /** 登录请求参数 */
  private ILoginRequest loginRequest;

  /** 登录返回结果 */
  private Object result;
}
