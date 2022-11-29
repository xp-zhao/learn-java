package utils.transaction;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 事务处理工具类
 *
 * @author zhaoxiaoping
 * @date 2022-11-29
 */
public class TransactionUtils {

  public static void doAfterTransaction(DoTransactionCompletion doTransactionCompletion) {
    if (TransactionSynchronizationManager.isActualTransactionActive()) {
      TransactionSynchronizationManager.registerSynchronization(doTransactionCompletion);
    }
  }

  @Transactional
  public void doTx() {
    // start tx
    TransactionUtils.doAfterTransaction(
        new DoTransactionCompletion(
            () -> {
              // 事务执行成功之后的处理逻辑
              // send mq ...
            }));
    // end tx
  }
}

class DoTransactionCompletion implements TransactionSynchronization {

  public Runnable runnable;

  public DoTransactionCompletion(Runnable runnable) {
    this.runnable = runnable;
  }

  @Override
  public void afterCompletion(int status) {
    if (status == TransactionSynchronization.STATUS_COMMITTED) {
      this.runnable.run();
    }
  }
}
