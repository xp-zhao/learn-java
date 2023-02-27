package org.learn.spring.v14.bean;

import org.learn.spring.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoxiaoping
 * @date 2022-5-7
 */
@Component
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
