package com.example.feature.mock.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-3-6
 */
@Component
public class MockUserService {
  @Autowired private MockUserDao userDao;

  public MockUser queryUserById(String id) {
    return userDao.queryUserById(id);
  }

  public String registerUser(MockUser user) {
    return userDao.registerUser(user);
  }
}
