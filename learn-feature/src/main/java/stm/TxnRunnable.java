package stm;

/**
 * @author zhaoxiaoping
 * @date 2024-9-26
 */
@FunctionalInterface
public interface TxnRunnable {
  void run(Txn txn);
}
