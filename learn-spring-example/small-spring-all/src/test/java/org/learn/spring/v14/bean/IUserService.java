package org.learn.spring.v14.bean;

/**
 * @author zhaoxiaoping
 * @date 2022-2-16
 */
public interface IUserService {
  String queryUserInfo();

  String register(String userName);
}
