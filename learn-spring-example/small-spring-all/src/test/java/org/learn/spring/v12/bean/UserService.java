package org.learn.spring.v12.bean;

import lombok.extern.slf4j.Slf4j;
import org.learn.spring.beans.BeansException;
import org.learn.spring.beans.factory.DisposableBean;
import org.learn.spring.beans.factory.InitializingBean;
import org.learn.spring.beans.factory.config.BeanPostProcessor;

/**
 * 测试, 当实现了 BeanPostProcessor 接口时, 因为在容器刷新时会提前注册所有的 BeanPostProcessor , 又因为 getBeansOfType 会将所有的
 * BeanPostProcessor 加载一次, 此时 DefaultAdvisorAutoProxyCreator 还未被加载, 所以不会对 UserService 进行代理, 所以
 * UserService 会实例化并被注册到单例对象缓存 DefaultSingletonBeanRegistry.singletonObjects 中,
 * UserServiceBeforeAdvice 不会生效
 *
 * @author zhaoxiaoping
 * @date 2023-2-23
 */
@Slf4j
public class UserService
    implements IUserService, DisposableBean, InitializingBean, BeanPostProcessor {
  @Override
  public String queryUserInfo() {
    return "查询用户信息";
  }

  @Override
  public String register(String userName) {
    return "注册用户：" + userName + " success！";
  }

  @Override
  public void destroy() throws Exception {
    log.info("UserService.destroy");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("UserService.afterPropertiesSet");
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if (beanName.equals("userService")) {
      log.info("UserService.postProcessBeforeInitialization");
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (beanName.equals("userService")) {
      log.info("UserService.postProcessAfterInitialization");
    }
    return bean;
  }
}
