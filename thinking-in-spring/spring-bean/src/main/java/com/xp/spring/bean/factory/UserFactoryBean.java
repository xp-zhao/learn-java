package com.xp.spring.bean.factory;

import com.xp.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author zhaoxiaoping
 * @Description: {@link User} Bean 的 {@link FactoryBean} 实现
 * @Date 2021-3-26
 **/
public class UserFactoryBean implements FactoryBean {

  @Override
  public Object getObject() throws Exception {
    return User.createUser();
  }

  @Override
  public Class<?> getObjectType() {
    return User.class;
  }
}
