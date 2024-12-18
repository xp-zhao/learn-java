package org.learn.rbac.resource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.learn.rbac.application.AccountApplicationService;
import org.learn.rbac.domain.account.Account;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 用户资源
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Path("/accounts")
@Component
@CacheConfig(cacheNames = "resource.account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AccountResource {

  @Inject private AccountApplicationService service;

  /** 获取系统中所有的用户信息 */
  @GET
  @Cacheable(key = "'ALL_ACCOUNT'")
  public Iterable<Account> getAllAccount() {
    return service.getAllAccounts();
  }

  /** 根据用户id获取用户详情 */
  @GET
  @Path("/{id}")
  @Cacheable(key = "#id")
  public Account getAccountById(@PathParam("id") Integer id) {
    return service.getAccountById(id);
  }
}
