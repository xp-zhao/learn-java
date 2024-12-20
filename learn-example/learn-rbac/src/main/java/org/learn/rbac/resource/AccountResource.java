package org.learn.rbac.resource;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.learn.rbac.application.AccountApplicationService;
import org.learn.rbac.domain.account.Account;
import org.learn.rbac.infrastructure.jaxrs.CommonResponse;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

  /** 创建新用户 */
  @POST
  @Caching(evict = {@CacheEvict(key = "#user.username"), @CacheEvict(key = "'ALL_ACCOUNT'")})
  public Response createUser(@Valid Account user) {
    return CommonResponse.op(() -> service.createAccount(user));
  }

  /** 更新用户信息 */
  @PUT
  @Caching(evict = {@CacheEvict(key = "#user.username"), @CacheEvict(key = "'ALL_ACCOUNT'")})
  public Response updateUser(@Valid Account user) {
    return CommonResponse.op(() -> service.updateAccount(user));
  }

  /** 删除用户信息 */
  @DELETE
  @Path("/{id}")
  @Caching(evict = {@CacheEvict(key = "#id"), @CacheEvict(key = "'ALL_ACCOUNT'")})
  public Response removeAccount(@PathParam("id") Integer id) {
    return CommonResponse.op(() -> service.removeAccount(id));
  }
}
