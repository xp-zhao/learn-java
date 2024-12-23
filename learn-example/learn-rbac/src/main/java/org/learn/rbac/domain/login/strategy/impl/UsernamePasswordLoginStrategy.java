package org.learn.rbac.domain.login.strategy.impl;

import lombok.extern.slf4j.Slf4j;
import org.learn.rbac.domain.login.context.LoginDataContext;
import org.learn.rbac.domain.login.strategy.AbstractLoginStrategy;

/**
 * @author xp-zhao
 * @description 用户名密码登录策略
 * @date 2024/12/21 23:00
 */
@Slf4j
public class UsernamePasswordLoginStrategy extends AbstractLoginStrategy {

  @Override
  protected void validateData(LoginDataContext loginDataContext) {}

  @Override
  protected void executeLogin(LoginDataContext loginDataContext) {}

  @Override
  protected void buildDataResult(LoginDataContext loginDataContext) {}
}
