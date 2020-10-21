package concurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 利用两个条件变量快速实现阻塞队列
 * @author xp-zhao
 * @param <T>
 */
public class BlockedQueue<T> {
    final Lock lock = new ReentrantLock();
    /** 条件变量，队列不满 */
    final Condition notFull = lock.newCondition();
    /** 条件变量，队列不空 */
    final Condition notEmpty = lock.newCondition();

    /**
     * 入队
     * @param t
     */
    void enqueue(T t) throws InterruptedException {
        lock.lock();
        try {
            while (isFull()) {
                //队列已满，等待队列不满
                notFull.await();
            }
            // 入队操作
            // 入队后，通知可出队
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }
    }

    T dequeue() throws InterruptedException {
        lock.lock();
        try{
            while (isEmpty()) {
                // 队列已空，等待队列不空
                notEmpty.await();
            }
            // 出队操作
            // 出队后，通知可入队
            notFull.signalAll();
        }finally {
            lock.unlock();
        }
        return null;
    }

    boolean isFull(){
        return true;
    }

    boolean isEmpty(){
        return true;
    }
}
