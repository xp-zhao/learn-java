package com.example.feature.mock.bean;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-3-6
 */
@Component
public class MockUserDao {
  private static Map<String, MockUser> userMap = new HashMap<>();

  static {
    userMap.put("10001", new MockUser("10001", "xxx-1"));
    userMap.put("10002", new MockUser("10002", "xxx-2"));
    userMap.put("10003", new MockUser("10003", "xxx-3"));
  }

  public MockUser queryUserById(String id) {
    return userMap.get(id);
  }

  public String registerUser(MockUser user) {
    userMap.put(user.getId(), user);
    return user.getId();
  }
}
