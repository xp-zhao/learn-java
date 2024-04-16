package org.learn.security.controller.request;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2024/4/16
 */
@Data
public class SignInReq {
  private String username;
  private String password;
}
