package org.learn.spring.v5.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
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
