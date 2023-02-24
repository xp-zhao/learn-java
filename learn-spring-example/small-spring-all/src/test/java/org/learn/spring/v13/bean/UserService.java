package org.learn.spring.v13.bean;

import org.learn.spring.stereotype.Component;

import java.util.Random;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-24
 */
@Component("userService")
public class UserService implements IUserService {

  private String token;

  @Override
  public String queryUserInfo() {
    try {
      Thread.sleep(new Random(1).nextInt(100));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "查询用户信息";
  }

  @Override
  public String register(String userName) {
    try {
      Thread.sleep(new Random(1).nextInt(100));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return "注册用户：" + userName + " success！";
  }

  @Override
  public String toString() {
    return "UserService#token = { " + token + " }";
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
