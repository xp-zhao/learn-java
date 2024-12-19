package org.learn.rbac.application;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import org.learn.rbac.domain.account.Account;
import org.learn.rbac.domain.account.AccountRepository;

/**
 * 用户资源接口
 *
 * @author zhaoxiaoping
 * @date 2024-12-18
 */
@Named
@Transactional
public class AccountApplicationService {
  @Inject private AccountRepository accountRepository;

  public Iterable<Account> getAllAccounts() {
    return accountRepository.findAll();
  }

  public Account getAccountById(Integer id) {
    return accountRepository.findById(id).orElse(null);
  }

  public void createAccount(Account account) {
    accountRepository.save(account);
  }
}
