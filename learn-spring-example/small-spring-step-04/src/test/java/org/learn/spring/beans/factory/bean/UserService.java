package org.learn.spring.beans.factory.bean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class UserService {

  private String uId;

  private UserDao userDao;

  public void queryUserInfo() {
    System.out.println("查询用户信息：" + userDao.queryUserName(uId));
  }

  public String getUId() {
    return uId;
  }

  public void setUId(String uId) {
    this.uId = uId;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
