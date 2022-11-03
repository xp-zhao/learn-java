package com.example.mp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2022-11-1
 */
@Data
public class User {
  @TableId(type = IdType.ASSIGN_ID)
  private Long id;

  private String name;
  private Integer age;
  private String email;
}
