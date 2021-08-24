package org.tiny.bean;

/** @author zhaoxiaoping @Description: 测试类 @Date 2021-8-19 */
public class UserService {
  private String id;
  private String company;
  private String location;
  private UserDao userDao;

  public UserService() {}

  public String queryUserInfo() {
    return userDao.queryUserName(id) + "," + company + "," + location;
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

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
