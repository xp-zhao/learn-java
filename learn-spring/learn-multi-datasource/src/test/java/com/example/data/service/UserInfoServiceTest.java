package com.example.data.service;

import com.example.data.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhaoxiaoping
 * @date 2024-4-24
 */
@Slf4j
@SpringBootTest
public class UserInfoServiceTest {
  @Autowired private UserInfoOneService oneService;
  @Autowired private UserInfoTwoService twoService;

  @Test
  public void testOne() {
    UserInfo entity = oneService.lambdaQuery().eq(UserInfo::getId, 1).one();
    log.info("查询结果：{}", entity);
  }

  @Test
  public void testTwo() {
    UserInfo entity = twoService.lambdaQuery().eq(UserInfo::getId, 1).one();
    log.info("查询结果：{}", entity);
  }
}
