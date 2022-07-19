package org.learn.mybatis;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 映射器代理工厂
 *
 * @author zhaoxiaoping
 * @date 2022-7-19
 */
public class MapperProxyFactory<T> {
  private final Class<T> mapperInterface;

  public MapperProxyFactory(Class<T> mapperInterface) {
    this.mapperInterface = mapperInterface;
  }

  public T newInstance(Map<String, String> sqlSession) {
    final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
    return (T)
        Proxy.newProxyInstance(
            mapperInterface.getClassLoader(), new Class[] {mapperInterface}, mapperProxy);
  }
}
