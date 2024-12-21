package org.learn.rbac.domain.login.request.impl;

import lombok.Data;
import org.learn.rbac.domain.login.request.ILoginRequest;

/**
 * @author xp-zhao
 * @description 用户名密码登录请求参数
 * @date 2024/12/21 22:54
 */
@Data
public class UsernamePasswordLoginRequest implements ILoginRequest {

  /** 用户名 */
  private String username;
  /** 密码 */
  private String password;
}
