package com.example.client;

import lombok.Data;

/** @author zhaoxiaoping @Description: 注册响应 @Date 2021-10-13 */
@Data
public class RegisterResponse {
  public static final String SUCCESS = "success";
  public static final String FAILURE = "failure";
  private String status;
}
