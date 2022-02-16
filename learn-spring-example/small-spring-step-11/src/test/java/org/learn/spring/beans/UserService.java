package org.learn.spring.beans;

import java.util.Random;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public class UserService implements IUserService {

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
}
