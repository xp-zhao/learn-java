package com.xp.spring.ioc.overview.repository;

import com.xp.spring.ioc.overview.domain.User;
import java.util.Collection;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

/**
 * @author zhaoxiaoping
 * @Description: 用户信息仓库
 * @Date 2021-3-25
 **/
public class UserRepository {


  private Collection<User> users;

  private BeanFactory beanFactory;

  private ObjectFactory<ApplicationContext> objectFactory;

  public Collection<User> getUsers() {
    return users;
  }

  public void setUsers(Collection<User> users) {
    this.users = users;
  }

  public BeanFactory getBeanFactory() {
    return beanFactory;
  }

  public void setBeanFactory(BeanFactory beanFactory) {
    this.beanFactory = beanFactory;
  }

  public ObjectFactory<ApplicationContext> getObjectFactory() {
    return objectFactory;
  }

  public void setObjectFactory(
      ObjectFactory<ApplicationContext> objectFactory) {
    this.objectFactory = objectFactory;
  }
}
