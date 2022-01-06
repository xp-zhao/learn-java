package org.learn.spring.beans.factory.bean;

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

  public void initDataMethod() {
    System.out.println("执行：init-method");
    hashMap.put("10001", "xxx-1");
    hashMap.put("10002", "xxx-2");
    hashMap.put("10003", "xxx-3");
  }

  public void destroyDataMethod() {
    System.out.println("执行：destroy-method");
    hashMap.clear();
  }

  public String queryUserName(String uId) {
    return hashMap.get(uId);
  }
}
