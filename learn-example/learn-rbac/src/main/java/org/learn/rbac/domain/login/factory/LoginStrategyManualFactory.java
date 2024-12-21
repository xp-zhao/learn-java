package org.learn.rbac.domain.login.factory;

import java.util.HashMap;
import java.util.Map;
import org.apache.catalina.User;
import org.learn.rbac.domain.login.enums.LoginStrategyEnum;
import org.learn.rbac.domain.login.strategy.LoginStrategy;
import org.learn.rbac.domain.login.strategy.impl.SmsLoginStrategy;
import org.learn.rbac.domain.login.strategy.impl.UsernamePasswordLoginStrategy;

/**
 * @author xp-zhao
 * @description 登录策略工厂
 * @date 2024/12/21 22:57
 */
public class LoginStrategyManualFactory {

  private static Map<String, LoginStrategy> registerStrategyMap = new HashMap<>();

  static {
    registerStrategyMap.put(LoginStrategyEnum.SMS_CODE_LOGIN.getKey(), new SmsLoginStrategy());
    registerStrategyMap.put(
        LoginStrategyEnum.USERNAME_PASSWORD_LOGIN.getKey(), new UsernamePasswordLoginStrategy());
  }

  public static LoginStrategy getLoginStrategy(LoginStrategyEnum loginStrategyEnum) {
    return registerStrategyMap.get(loginStrategyEnum.getKey());
  }
}
