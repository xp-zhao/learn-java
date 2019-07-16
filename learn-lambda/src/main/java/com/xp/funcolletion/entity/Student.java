package com.xp.funcolletion.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student.java 学生对象实体
 *
 * @author: zhaoxiaoping
 * @date: 2019/07/16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private String name;
  private int age;
  private int stature;
  private List<SpecialityEnum> specialises;

  public Student(String name, int age, int stature){
    this.name = name;
    this.age = age;
    this.stature = stature;
  }
}