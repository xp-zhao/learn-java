package org.learn.spring.v6.bean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-3
 */
public class UserService {
  private String uId;

  private String name;

  private String location;

  private UserDao userDao;

  public String queryUserInfo() {
    return userDao.queryUserName(uId) + ", " + name + "," + location;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
