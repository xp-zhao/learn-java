package stm;

/**
 * 事务接口
 *
 * @author zhaoxiaoping
 * @date 2024-9-26
 */
public interface Txn {
  /** 获取当前事务中的数据 */
  <T> T get(TxnRef<T> ref);

  /** 在当前事务中设置数据 */
  <T> void set(TxnRef<T> ref, T value);
}
