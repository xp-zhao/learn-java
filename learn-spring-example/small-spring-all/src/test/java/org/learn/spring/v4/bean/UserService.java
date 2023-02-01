package org.learn.spring.v4.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试服务类
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
@Slf4j
public class UserService {

  private String uId;

  private UserDao userDao;

  public void queryUserInfo() {
    log.info("查询用户信息：" + userDao.queryUserName(uId));
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
