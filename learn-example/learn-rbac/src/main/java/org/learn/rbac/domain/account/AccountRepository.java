package org.learn.rbac.domain.account;

import java.util.Optional;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

/**
 * 用户数据仓库
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@CacheConfig(cacheNames = "repository.account")
public interface AccountRepository extends CrudRepository<Account, Integer> {
  @Override
  Iterable<Account> findAll();

  @Cacheable(key = "#id")
  Optional<Account> findById(Integer id);
}
