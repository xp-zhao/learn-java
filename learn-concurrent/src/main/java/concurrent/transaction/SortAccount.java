package concurrent.transaction;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date
 **/
public class SortAccount {

  private int id;
  private int balance;

  /**
   * 转账
   */
  void transfer(SortAccount target, int amt) {
    SortAccount left = this;
    SortAccount right = target;
    if (this.id > target.id) {
      left = target;
      right = this;
    }
    // 锁定序号小的账号
    synchronized (left) {
      // 锁定序号大的账号
      synchronized (right) {
        if (this.balance > amt) {
          this.balance -= amt;
          target.balance += amt;
        }
      }
    }
  }
}
