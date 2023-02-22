package org.learn.spring.v9.bean;

import lombok.extern.slf4j.Slf4j;
import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.InitializingBean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
@Slf4j
public class UserService implements InitializingBean, DisposableBean {
  private String uId;

  private String name;

  private String location;

  private IUserDao userDao;

  public String queryUserInfo() {
    return userDao.queryUserName(uId) + ", " + name + "," + location;
  }

  public String getUId() {
    return uId;
  }

  public void setUId(String uId) {
    this.uId = uId;
  }

  public IUserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(IUserDao userDao) {
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
    log.info("执行：UserService.destroy");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("执行：UserService.afterPropertiesSet");
  }
}
