package org.learn.spring.test.beans;

import java.util.Random;
import org.learn.spring.stereotype.Component;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
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
    return "xxx，100001，深圳";
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
