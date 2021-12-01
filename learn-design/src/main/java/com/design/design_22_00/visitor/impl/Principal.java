package com.design.design_22_00.visitor.impl;

import com.design.design_22_00.user.impl.Student;
import com.design.design_22_00.user.impl.Teacher;
import com.design.design_22_00.visitor.Visitor;
import lombok.extern.slf4j.Slf4j;

/**
 * 校长访问视角
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
@Slf4j
public class Principal implements Visitor {

  @Override
  public void visit(Student student) {
    log.info("学生信息 姓名：{} 班级：{}", student.name, student.clazz);
  }

  @Override
  public void visit(Teacher teacher) {
    log.info("老师信息 姓名：{} 班级：{} 升学率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
  }
}
