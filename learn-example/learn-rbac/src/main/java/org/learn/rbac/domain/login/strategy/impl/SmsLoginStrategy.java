package org.learn.rbac.domain.login.strategy.impl;

import lombok.extern.slf4j.Slf4j;
import org.learn.rbac.domain.login.context.LoginDataContext;
import org.learn.rbac.domain.login.request.ILoginRequest;
import org.learn.rbac.domain.login.request.impl.SmsLoginRequest;
import org.learn.rbac.domain.login.strategy.AbstractLoginStrategy;

/**
 * @author xp-zhao
 * @description 短信验证码登录
 * @date 2024/12/21 23:00
 */
@Slf4j
public class SmsLoginStrategy extends AbstractLoginStrategy {
  @Override
  protected void validateData(LoginDataContext loginDataContext) {
    ILoginRequest loginRequest = loginDataContext.getLoginRequest();
    if (loginRequest instanceof SmsLoginRequest) {
      SmsLoginRequest smsLoginRequest = (SmsLoginRequest) loginRequest;
      log.info("短信验证码登录参数校验：{}", smsLoginRequest);
    }
  }

  @Override
  protected void executeLogin(LoginDataContext loginDataContext) {}

  @Override
  protected void buildDataResult(LoginDataContext loginDataContext) {}
}
