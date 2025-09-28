package com.example.feature.controller.entity;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2024-6-3
 */
@Data
@AllArgsConstructor
public class UserEntity {
  @NotBlank(message = "userId 不能为空")
  private String userId;

  private String userName;
}
