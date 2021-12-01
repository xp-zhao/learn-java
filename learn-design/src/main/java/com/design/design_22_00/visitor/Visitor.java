package com.design.design_22_00.visitor;

import com.design.design_22_00.user.impl.Student;
import com.design.design_22_00.user.impl.Teacher;

/**
 * 访问接口
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public interface Visitor {
  /**
   * 访问学生信息
   *
   * @param student 学生
   */
  void visit(Student student);

  /**
   * 访问老师信息
   *
   * @param teacher 老师
   */
  void visit(Teacher teacher);
}
