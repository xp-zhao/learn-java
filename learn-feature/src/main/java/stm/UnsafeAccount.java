package stm;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 简单模拟转账时的并发问题
 *
 * @author zhaoxiaoping
 * @date 2024-9-27
 */
@Slf4j
@Data
public class UnsafeAccount {
  private int balance;

  public UnsafeAccount(int balance) {
    this.balance = balance;
  }

  /**
   * 转账
   *
   * @param target 目标用户
   * @param amt 转账金额
   */
  void transfer(UnsafeAccount target, int amt) {
    if (this.balance > amt) {
      this.balance -= amt;
      target.balance += amt;
    }
  }

  public static void main(String[] args) {
    UnsafeAccount source = new UnsafeAccount(1000);
    UnsafeAccount target = new UnsafeAccount(1000);

    Runnable sourceToTarget =
        () -> {
          for (int i = 0; i < 100; i++) {
            source.transfer(target, 10);
          }
        };
    Runnable targetToSource =
        () -> {
          for (int i = 0; i < 100; i++) {
            target.transfer(source, 10);
          }
        };
    Thread t1 = new Thread(sourceToTarget, "Thread source to target");
    Thread t2 = new Thread(targetToSource, "Thread target to source");

    t1.start();
    t2.start();
    try {
      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Final Balances:");
    System.out.println("Account Source: " + source.getBalance());
    System.out.println("Account Target: " + target.getBalance());
  }
}
