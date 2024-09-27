package stm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * STM 事务实现类
 *
 * @author zhaoxiaoping
 * @date 2024-9-26
 */
public final class STMTxn implements Txn {

  /** 事务 ID 生成器 */
  private static AtomicLong txnSeq = new AtomicLong(0);

  /** 当前事务所有的相关数据 */
  private Map<TxnRef, VersionedRef> inTxnMap = new HashMap<>();

  /** 当前事务所有需要修改的数据 */
  private Map<TxnRef, Object> writeMap = new HashMap<>();

  /** 当前事务 ID */
  private long txnId;

  STMTxn() {
    /** 自动生成当前事务 ID */
    txnId = txnSeq.incrementAndGet();
  }

  @Override
  public <T> T get(TxnRef<T> ref) {
    if (!inTxnMap.containsKey(ref)) {
      inTxnMap.put(ref, ref.curRef);
    }
    return (T) inTxnMap.get(ref).value;
  }

  @Override
  public <T> void set(TxnRef<T> ref, T value) {
    if (!inTxnMap.containsKey(ref)) {
      inTxnMap.put(ref, ref.curRef);
    }
    writeMap.put(ref, value);
  }

  /** 提交事务 */
  boolean commit() {
    synchronized (STM.commitLock) {
      boolean isValid = true;
      // 校验所有读过的数据是否发生过变化
      for (Map.Entry<TxnRef, VersionedRef> entry : inTxnMap.entrySet()) {
        VersionedRef curRef = entry.getKey().curRef;
        VersionedRef readRef = entry.getValue();
        // 通过版本号来判断数据是否发生过变化
        if (curRef.version != readRef.version) {
          isValid = false;
          break;
        }
      }
      if (isValid) {
        writeMap.forEach(
            (k, v) -> {
              k.curRef = new VersionedRef(v, txnId);
            });
      }
      return isValid;
    }
  }
}
