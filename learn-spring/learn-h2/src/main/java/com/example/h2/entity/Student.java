package com.example.h2.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2024-4-3
 */
@Data
@TableName("`student`")
public class Student {
  private Long id;
  private String name;
  private Integer age;
  private String email;
}
