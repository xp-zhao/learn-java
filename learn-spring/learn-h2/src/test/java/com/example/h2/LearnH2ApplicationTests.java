package com.example.h2;

import com.example.h2.dao.UserDao;
import com.example.h2.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
class LearnH2ApplicationTests {

  @Resource private UserDao userDao;

  @Test
  void contextLoads() {
    UserEntity user = userDao.query(1);
    log.info("查询结果：{}", user);
  }
}
