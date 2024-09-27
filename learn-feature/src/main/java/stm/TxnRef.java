package stm;

/**
 * 支持事务的对象引用
 *
 * @author zhaoxiaoping
 * @date 2024-9-26
 */
public class TxnRef<T> {
  /** 当前数据，带版本号 */
  volatile VersionedRef curRef;

  public TxnRef(T value) {
    this.curRef = new VersionedRef(value, 0L);
  }

  public T getValue(Txn txn) {
    return txn.get(this);
  }

  public void setValue(T value, Txn txn) {
    txn.set(this, value);
  }
}
