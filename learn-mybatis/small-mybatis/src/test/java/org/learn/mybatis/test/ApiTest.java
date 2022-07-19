package org.learn.mybatis.test;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.learn.mybatis.MapperProxyFactory;
import org.learn.mybatis.test.dao.IUserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zhaoxiaoping
 * @date 2022-7-19
 */
public class ApiTest {
  private Logger logger = LoggerFactory.getLogger(ApiTest.class);

  @Test
  public void test_MapperProxyFactory() {
    MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

    Map<String, String> sqlSession = new HashMap<>();
    sqlSession.put(
        "org.learn.mybatis.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
    sqlSession.put(
        "org.learn.mybatis.test.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
    IUserDao userDao = factory.newInstance(sqlSession);

    String res = userDao.queryUserName("10001");
    logger.info("测试结果：{}", res);
  }

  @Test
  public void test_proxy_class() {
    IUserDao userDao =
        (IUserDao)
            Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[] {IUserDao.class},
                (proxy, method, args) -> 1);
    Integer result = userDao.queryUserAge("10001");
    System.out.println("测试结果：" + result);
  }
}
