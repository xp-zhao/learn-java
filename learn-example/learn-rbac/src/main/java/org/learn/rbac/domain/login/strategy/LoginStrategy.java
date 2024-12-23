package org.learn.rbac.domain.login.strategy;

import org.learn.rbac.domain.login.context.LoginDataContext;
import org.learn.rbac.domain.login.request.ILoginRequest;

/**
 * @author xp-zhao
 * @description 登录策略接口
 * @date 2024/12/21 22:50
 */
public interface LoginStrategy {
  /**
   * 登录接口
   *
   * @param loginRequest
   */
  LoginDataContext login(ILoginRequest loginRequest);
}
