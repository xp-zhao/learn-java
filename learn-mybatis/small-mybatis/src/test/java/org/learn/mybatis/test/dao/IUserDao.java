package org.learn.mybatis.test.dao;

/**
 * @author zhaoxiaoping
 * @date 2022-7-19
 */
public interface IUserDao {
  String queryUserName(String uId);

  Integer queryUserAge(String uId);
}
