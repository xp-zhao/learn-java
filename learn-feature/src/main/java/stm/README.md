## 介绍

从数据库的事务管理中获取的灵感, 总结出的并发解决方案 **软件事务内存(Software Transactional Memory，简称STM)**,
简单总结就是为每条数据增加一个版本号, 每次对数据成功修改之后都会增加版本号的值, 在每次提交修改时去判断版本号有没有变化,
如果发生了变化则说明数据再其它地方被修改了, 那么当前的修改就直接失败

## 不安全的转账示例

```java

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
```

上面的代码示例中, source 向 target 转账 100 次, 每次 10, 同事 target 也像 source 执行相同的操作, 正常情况下转账操作结束后,
两个账号的余额应该是一样的, 但这里因为有并发问题, 所以结果和预想的不一致

## 数据库事务解决方案

如果是在数据库中处理转账操作, 可以在所有转账 sql 执行成功之后再提交事务, 如果在转账过程中有异常, 则回滚事务,
这样就可以很方便的解决并发问题

```
Connection conn = null;
try{
  //获取数据库连接
  conn = DriverManager.getConnection();
  //设置手动提交事务
  conn.setAutoCommit(false);
  //执行转账SQL
  ......
  //提交事务
  conn.commit();
} catch (Exception e) {
  //出现异常回滚事务
  conn.rollback();
}
```

## 实现简单的 STM

### 为所有的对象增加版本号

定义一个 VersionedRef 类, 将对象 value 包装成带版本号的对象, 并且用 final 修饰成不可变的类, 保证数据的每次修改都对应一个版本号,
不会存在只修改对象值或者版本号的情况

```java
public final class VersionedRef<T> {
    final T value;
    final long version;

    public VersionedRef(T value, long version) {
        this.value = value;
        this.version = version;
    }
}

```

## 使对象支持事务引用

定义事务接口 Txn, 并将读写操作委托给事务接口, 同时新增支持事务的引用类 TxnRef, 负责完成事务内的读写操作

```java
import stm.VersionedRef;

public interface Txn {
  /** 获取当前事务中的数据 */
  <T> T get(TxnRef<T> ref);

  /** 在当前事务中设置数据 */
  <T> void set(TxnRef<T> ref, T value);
}

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

```
