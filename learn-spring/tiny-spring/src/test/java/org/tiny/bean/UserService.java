package org.tiny.bean;

/** @author zhaoxiaoping @Description: 测试类 @Date 2021-8-19 */
public class UserService {
  private String id;
  private UserDao userDao;

  public UserService() {}

  public void queryUserInfo() {
    System.out.println("查询用户信息 " + userDao.queryUserName(id));
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
