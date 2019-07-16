package com.xp.funcolletion.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StudentClass.java 班级对象实体
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentClass {
  private String name;
  private List<Student> students;
}