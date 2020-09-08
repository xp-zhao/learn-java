package com.xp.service;

import com.xp.dao.UserDao;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-8
 **/
public class UserServiceImpl implements UserService {

  private UserDao userDao;

  /**
   * 利用 set 进行动态实现值的注入
   *
   * @param userDao
   */
  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

  public void getUser() {
    userDao.getUser();
  }
}
