package com.xp.dynamicplus;

import com.xp.plus.UserService;
import com.xp.plus.UserServiceImpl;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020-9-16
 **/
public class Client {

  public static void main(String[] args) {
    // 真实角色
    UserService userService = new UserServiceImpl();
    // 代理角色
    ProxyInvocationHandler handler = new ProxyInvocationHandler();
    // 设置要代理的对象
    handler.setTarget(userService);
    // 动态生成代理类
    UserService proxy = (UserService) handler.getProxy();
    proxy.add();
  }
}
