package com.example.h2.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.h2.dao.StudentMapper;
import com.example.h2.entity.Student;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2024-4-3
 */
@Service
public class StudentService extends ServiceImpl<StudentMapper, Student> {
  public boolean updateStudentById(Integer id) {
    return this.lambdaUpdate()
        .set(Student::getName, "updated-name")
        .eq(Student::getId, id)
        .update();
  }

  public boolean updateException(Integer id) {
    this.lambdaUpdate().set(Student::getName, "updated-name").eq(Student::getId, id).update();
    throw new RuntimeException();
  }
}
