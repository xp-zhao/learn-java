package org.learn.spring.v15.bean;

import java.util.Random;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class UserService implements IUserService {

  private String token;

  public String queryUserInfo() {
    try {
      Thread.sleep(new Random(1).nextInt(100));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "查询用户信息 " + token;
  }

  public String register(String userName) {
    try {
      Thread.sleep(new Random(1).nextInt(100));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "注册用户：" + userName + " success！";
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
