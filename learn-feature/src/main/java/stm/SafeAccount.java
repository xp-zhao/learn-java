package stm;

import cn.hutool.core.convert.Convert;

/**
 * @author zhaoxiaoping
 * @date 2024-9-26
 */
public class SafeAccount {
  private TxnRef<Integer> balance;

  public SafeAccount(int balance) {
    this.balance = new TxnRef<>(balance);
  }

  public void transfer(SafeAccount target, int amt) {
    TxnRunnable txnRunnable =
        (txn) -> {
          Integer from = balance.getValue(txn);
          balance.setValue(from - amt, txn);
          Integer to = target.balance.getValue(txn);
          target.balance.setValue(to + amt, txn);
        };
    STM.atomic(txnRunnable);
  }

  public int getBalance() {
    return Convert.toInt(balance.curRef.value);
  }

  public static void main(String[] args) {
    SafeAccount source = new SafeAccount(1000);
    SafeAccount target = new SafeAccount(1000);

    source.transfer(target, 100);
    //    Runnable sourceToTarget =
    //        () -> {
    //          for (int i = 0; i < 100; i++) {
    //            source.transfer(target, 10);
    //          }
    //        };
    //    Runnable targetToSource =
    //        () -> {
    //          for (int i = 0; i < 100; i++) {
    //            target.transfer(source, 10);
    //          }
    //        };
    //    Thread t1 = new Thread(sourceToTarget, "Thread source to target");
    //    Thread t2 = new Thread(targetToSource, "Thread target to source");
    //
    //    t1.start();
    //    t2.start();
    //    try {
    //      t1.join();
    //      t2.join();
    //    } catch (InterruptedException e) {
    //      e.printStackTrace();
    //    }

    System.out.println("Final Balances:");
    System.out.println("Account Source: " + source.getBalance());
    System.out.println("Account Target: " + target.getBalance());
  }
}
