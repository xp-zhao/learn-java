package com.example.h2;

import com.example.h2.dao.StudentMapper;
import com.example.h2.entity.Student;
import com.example.h2.service.StudentService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class LearnH2ApplicationTests {

  @Autowired private StudentMapper studentMapper;
  @Autowired private StudentService studentService;

  @Test
  public void testQuery() {
    List<Student> list = studentMapper.query();
    log.info("查询结果：{}", list);
  }

  @Test
  public void testSelect() {
    List<Student> students = studentMapper.selectList(null);
    log.info("查询结果：{}", students);
  }

  @Test
  public void testService() {
    Student student = studentService.lambdaQuery().eq(Student::getId, 1).one();
    log.info("查询结果：{}", student);
  }
}
