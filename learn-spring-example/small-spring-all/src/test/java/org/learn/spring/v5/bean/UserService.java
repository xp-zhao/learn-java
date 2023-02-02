package org.learn.spring.v5.bean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class UserService {

  private String uId;

  private UserDao userDao;

  public String queryUserInfo() {
    return userDao.queryUserName(uId);
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
