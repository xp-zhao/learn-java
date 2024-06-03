package com.example.feature.controller.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author zhaoxiaoping
 * @date 2024-6-3
 */
@Data
public class UserEntity {
  @NotBlank(message = "userId 不能为空")
  private String userId;

  private String userName;
}
