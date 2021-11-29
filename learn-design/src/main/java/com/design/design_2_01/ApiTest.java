package com.design.design_2_01;

import com.xp.creator.abstractfactory.v1.CacheService;
import com.xp.creator.abstractfactory.v1.impl.CacheServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Slf4j
public class ApiTest {

  @Test
  public void testCacheService() {

    CacheService cacheService = new CacheServiceImpl();

    cacheService.set("user_name_01", "xxx", 2);
    String val01 = cacheService.get("user_name_01", 2);
    log.info("测试结果：{}", val01);
  }
}
