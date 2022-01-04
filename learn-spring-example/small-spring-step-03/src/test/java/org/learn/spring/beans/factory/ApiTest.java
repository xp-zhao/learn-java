package org.learn.spring.beans.factory;

import java.lang.reflect.Constructor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;
import org.learn.spring.beans.factory.bean.UserService;
import org.learn.spring.beans.factory.config.BeanDefinition;
import org.learn.spring.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {
  @Test
  public void testBeanFactory() {
    // 1.初始化 BeanFactory
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    // 2.注册 bean
    BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
    beanFactory.registerBeanDefinition("userService", beanDefinition);
    // 3.第一次获取 bean
    UserService userService = (UserService) beanFactory.getBean("userService", "xxx");
    userService.queryUserInfo();
  }

  @Test
  public void test_newInstance() throws IllegalAccessException, InstantiationException {
    UserService userService = UserService.class.newInstance();
    System.out.println(userService);
  }

  @Test
  public void test_constructor() throws Exception {
    Class<UserService> userServiceClass = UserService.class;
    Constructor<UserService> declaredConstructor =
        userServiceClass.getDeclaredConstructor(String.class);
    UserService userService = declaredConstructor.newInstance("xxx");
    System.out.println(userService);
  }

  @Test
  public void test_parameterTypes() throws Exception {
    Class<UserService> beanClass = UserService.class;
    Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
    Constructor<?> constructor = declaredConstructors[1];
    Constructor<UserService> declaredConstructor =
        beanClass.getDeclaredConstructor(constructor.getParameterTypes());
    UserService userService = declaredConstructor.newInstance("xxx");
    System.out.println(userService);
  }

  @Test
  public void test_cglib() {
    Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(UserService.class);
    enhancer.setCallback(
        new NoOp() {
          @Override
          public int hashCode() {
            return super.hashCode();
          }
        });
    Object obj = enhancer.create(new Class[] {String.class}, new Object[] {"xxx"});
    System.out.println(obj);
  }
}
