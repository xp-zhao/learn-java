package org.learn.mybatis;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 映射器代理类
 *
 * @author zhaoxiaoping
 * @date 2022-7-19
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

  private Map<String, String> sqlSession;
  private final Class<T> mapperInterface;

  public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
    this.sqlSession = sqlSession;
    this.mapperInterface = mapperInterface;
  }
  
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (Object.class.equals(method.getDeclaringClass())) {
      return method.invoke(this, args);
    } else {
      return "你的被代理了！" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
    }
  }
}
