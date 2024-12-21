package org.learn.rbac.domain.login.request.impl;

import lombok.Data;

/**
 * @author xp-zhao
 * @description 短信验证码登录请求参数
 * @date 2024/12/21 22:55
 */
@Data
public class SmsLoginRequest {

  /** 手机号 */
  private String phone;
  /** 验证码 */
  private String code;
}
