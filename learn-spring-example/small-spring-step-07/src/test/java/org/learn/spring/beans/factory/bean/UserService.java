package org.learn.spring.beans.factory.bean;

import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.InitializingBean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2022-1-4
 */
public class UserService implements InitializingBean, DisposableBean {

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

  @Override
  public void destroy() throws Exception {
    System.out.println("执行：UserService.destroy");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("执行：UserService.afterPropertiesSet");
  }
}
