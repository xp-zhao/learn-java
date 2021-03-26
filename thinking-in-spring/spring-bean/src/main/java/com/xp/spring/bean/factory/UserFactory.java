package com.xp.spring.bean.factory;

import com.xp.spring.ioc.overview.domain.User;

/**
 * @author zhaoxiaoping
 * @Description: {@link User} 工厂类
 * @Date 2021-3-26
 **/
public interface UserFactory {

  /**
   * 创建用户
   *
   * @return
   */
  default User createUser() {
    return User.createUser();
  }
}
