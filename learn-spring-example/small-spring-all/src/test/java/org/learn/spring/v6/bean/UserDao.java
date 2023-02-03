package org.learn.spring.v6.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试类
 *
 * @author zhaoxiaoping
 * @date 2023-2-3
 */
public class UserDao {
  private static Map<String, String> hashMap = new HashMap<>();

  static {
    hashMap.put("10001", "xxx-1");
    hashMap.put("10002", "xxx-2");
    hashMap.put("10003", "xxx-3");
  }

  public String queryUserName(String uId) {
    return hashMap.get(uId);
  }
}
