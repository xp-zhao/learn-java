package org.learn.spring.test.beans;

import java.util.Random;
import org.learn.spring.beans.factory.annotation.Autowired;
import org.learn.spring.beans.factory.annotation.Value;
import org.learn.spring.stereotype.Component;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
@Component("userService")
public class UserService implements IUserService {

  @Value("${token}")
  private String token;

  @Autowired private UserDao userDao;

  public String queryUserInfo() {
    try {
      Thread.sleep(new Random(1).nextInt(100));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return userDao.queryUserName("10001") + "，" + token;
  }

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

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
