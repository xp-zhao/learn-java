package org.learn.spring;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 单元测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-1
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  org.learn.spring.v1.ApiTest.class,
  org.learn.spring.v2.ApiTest.class,
  org.learn.spring.v3.ApiTest.class,
  org.learn.spring.v4.ApiTest.class,
  org.learn.spring.v5.ApiTest.class,
  org.learn.spring.v6.ApiTest.class,
  org.learn.spring.v7.ApiTest.class,
  org.learn.spring.v8.ApiTest.class,
  org.learn.spring.v9.ApiTest.class,
  org.learn.spring.v10.ApiTest.class,
  org.learn.spring.v11.ApiTest.class,
  org.learn.spring.v12.ApiTest.class,
  org.learn.spring.v13.ApiTest.class,
  org.learn.spring.v14.ApiTest.class,
  org.learn.spring.v15.ApiTest.class,
  org.learn.spring.v16.ApiTest.class,
  org.learn.spring.v17.ApiTest.class
})
public class AllTests {}
