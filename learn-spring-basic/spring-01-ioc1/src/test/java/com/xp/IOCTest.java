package com.xp;

import com.xp.dao.UserDaoImpl;
import com.xp.service.UserServiceImpl;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-8
 **/
public class IOCTest {

  public static void main(String[] args) {
    UserServiceImpl userService = new UserServiceImpl();
    userService.setUserDao(new UserDaoImpl());
    userService.getUser();
  }
}
