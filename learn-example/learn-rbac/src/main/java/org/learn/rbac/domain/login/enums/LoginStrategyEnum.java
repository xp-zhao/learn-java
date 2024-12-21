package org.learn.rbac.domain.login.enums;

import lombok.Getter;

/**
 * @author xp-zhao
 * @description 登录策略枚举
 * @date 2024/12/21 22:47
 */
public enum LoginStrategyEnum {
  SMS_CODE_LOGIN("sms", "短信验证码登录"),
  USERNAME_PASSWORD_LOGIN("username_password", "用户名密码登录");
  private final String key;
  private final String name;

  LoginStrategyEnum(String key, String name) {
    this.key = key;
    this.name = name;
  }

  public String getKey() {
    return key;
  }
}
