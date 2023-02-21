package org.learn.spring.v8.bean;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-21
 */
@Slf4j
public class UserDao {
  private static Map<String, String> hashMap = new HashMap<>();

  public void initDataMethod() {
    log.info("执行：UserDao.init-method");
    hashMap.put("10001", "xxx-1");
    hashMap.put("10002", "xxx-2");
    hashMap.put("10003", "xxx-3");
  }

  public void destroyDataMethod() {
    log.info("执行：UserDao.destroy-method");
    hashMap.clear();
  }

  public String queryUserName(String uId) {
    return hashMap.get(uId);
  }
}
