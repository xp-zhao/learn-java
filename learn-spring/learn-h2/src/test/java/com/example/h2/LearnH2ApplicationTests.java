package com.example.h2;

import com.example.h2.dao.UserDao;
import com.example.h2.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class LearnH2ApplicationTests {

  @Resource private UserDao userDao;

  @Test
  void contextLoads() {
    UserEntity user = userDao.query(1);
    System.out.println(user);
  }
}
