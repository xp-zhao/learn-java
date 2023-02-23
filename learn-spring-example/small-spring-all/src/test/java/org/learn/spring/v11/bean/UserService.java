package org.learn.spring.v11.bean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-22
 */
public class UserService implements IUserService {
  @Override
  public String queryUserInfo() {
    return "用户信息查询";
  }

  @Override
  public String register(String userName) {
    return "注册用户 " + userName + " success！";
  }
}
