package com.xp.plus;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-16
 **/
public class Client {

  public static void main(String[] args) {
    UserService userService = new UserServiceImpl();
    UserServiceProxy proxy = new UserServiceProxy();
    proxy.setUserService(userService);
    proxy.delete();
  }

}
