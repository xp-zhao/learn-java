package com.xp.plus;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-16
 **/
public class UserServiceProxy implements UserService {

  private UserService userService;

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public void add() {
    log("add");
    userService.add();
  }

  public void delete() {
    log("delete");
    userService.delete();
  }

  public void update() {
    log("update");
    userService.update();
  }

  public void query() {
    log("query");
    userService.query();
  }

  private void log(String msg) {
    System.out.println("使用了" + msg + "方法");
  }
}
