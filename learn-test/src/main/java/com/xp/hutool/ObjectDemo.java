package com.xp.hutool;

import cn.hutool.core.util.ObjectUtil;
import com.xp.basics.Student;
import java.util.Optional;

/**
 * ObjectDemo.java ObjectUtil 使用示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/14
 **/
public class ObjectDemo {

  public static void main(String[] args) {
    Student student = null;
    System.out.println(ObjectUtil.isEmpty(student));
    System.out.println(ObjectUtil.isNull(student));
  }

  public static Optional<Student> test(){
    return Optional.empty();
  }
}