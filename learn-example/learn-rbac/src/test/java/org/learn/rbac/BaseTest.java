package org.learn.rbac;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.learn.rbac.domain.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 测试基类
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@Sql(scripts = {"classpath:db/hsqldb/schema.sql", "classpath:db/hsqldb/data.sql"})
@SpringBootTest(classes = RbacApplication.class)
public class BaseTest {
  @Autowired private CacheManager cacheManager;
  @Autowired private AccountRepository accountRepository;

  @Test
  public void emptyCache() {
    for (String name : cacheManager.getCacheNames()) {
      cacheManager.getCache(name).clear();
    }
  }
}
