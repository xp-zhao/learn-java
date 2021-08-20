package org.tiny.bean;

import java.util.HashMap;
import java.util.Map;

/** @author zhaoxiaoping @Description: 测试类 @Date 2021-8-20 */
public class UserDao {
  private static Map<String, String> hashMap = new HashMap<>();

  static {
    hashMap.put("10001", "10001");
    hashMap.put("10002", "10002");
    hashMap.put("10003", "10003");
  }

  public String queryUserName(String id) {
    return hashMap.get(id);
  }
}
