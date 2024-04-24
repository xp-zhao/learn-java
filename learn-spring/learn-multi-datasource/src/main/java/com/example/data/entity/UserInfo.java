package com.example.data.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2024-4-24
 */
@Data
@TableName("`USER_INFO`")
public class UserInfo {
  private Long id;
  private String name;
  private String email;
}
