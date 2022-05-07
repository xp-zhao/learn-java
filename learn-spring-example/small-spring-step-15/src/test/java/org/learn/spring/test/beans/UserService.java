package org.learn.spring.test.beans;

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
    return "小傅哥，100001，深圳，" + token;
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
