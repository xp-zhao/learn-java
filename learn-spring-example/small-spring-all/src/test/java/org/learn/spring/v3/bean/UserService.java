package org.learn.spring.v3.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试服务类
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
@Slf4j
public class UserService {

  private String name;

  public UserService() {}

  public UserService(String name) {
    this.name = name;
  }

  public void queryUserInfo() {
    log.info("查询用户信息: " + name);
  }
}
