package org.learn.rbac.domain.login.strategy;

import org.learn.rbac.domain.login.context.LoginDataContext;
import org.learn.rbac.domain.login.request.ILoginRequest;

/**
 * 登录策略抽象类
 *
 * @author zhaoxiaoping
 * @date 2024-12-23
 */
public abstract class AbstractLoginStrategy implements LoginStrategy {
  public LoginDataContext login(ILoginRequest loginRequest) {
    LoginDataContext context = new LoginDataContext();
    context.setLoginRequest(loginRequest);
    // 登录前置操作
    this.validateData(context);
    // 登录业务处理
    this.executeLogin(context);
    // 登录动作处理
    this.executeLoginAction(context);
    // 登录后置动作
    this.loginSuccessAfterAction(context);
    // 封装返回结果
    this.buildDataResult(context);
    return context;
  }

  protected abstract void validateData(LoginDataContext loginDataContext);

  protected abstract void executeLogin(LoginDataContext loginDataContext);

  protected void executeLoginAction(LoginDataContext loginDataContext) {}

  protected void loginSuccessAfterAction(LoginDataContext loginDataContext) {}

  protected abstract void buildDataResult(LoginDataContext loginDataContext);
}
