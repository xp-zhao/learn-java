package com.example.h2.utils;

import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * 事务工具类
 *
 * @author zhaoxiaoping
 * @date 2024-4-22
 */
@Slf4j
public class TransactionUtil {

  public static <R, P> R runWithNewTransaction(
      P parameter, Function<P, R> processFun, R defaultResult) {
    return runWithTransaction(
        TransactionDefinition.PROPAGATION_REQUIRES_NEW, parameter, processFun, defaultResult);
  }

  public static <R, P> R runWithTransaction(
      int propagationBehavior, P parameter, Function<P, R> processFun, R defaultResult) {
    // 开启事务
    DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
    defaultTransactionDefinition.setPropagationBehavior(propagationBehavior);
    PlatformTransactionManager txManager =
        SpringContextUtil.getApplicationContext().getBean(PlatformTransactionManager.class);
    TransactionStatus transactionStatus = txManager.getTransaction(defaultTransactionDefinition);
    try {
      R result = processFun.apply(parameter);
      txManager.commit(transactionStatus);
      return result;
    } catch (Exception e) {
      log.warn("以事务的方式执行异常", e);
      log.info("以事务的方式执行异常，事务回滚");
      txManager.rollback(transactionStatus);
      return defaultResult;
    }
  }
}
