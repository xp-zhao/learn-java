package org.example.queue.jvm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.example.entity.UserTakeSeckill;

/**
 * 秒杀队列
 *
 * @author zhaoxiaoping
 * @date 2023-9-8
 */
public class SeckillQueue {
  private static final Integer QUEUE_MAX_SIZE = 1000;
  private static final BlockingQueue<UserTakeSeckill> blockingQueue =
      new LinkedBlockingQueue<>(QUEUE_MAX_SIZE);

  private SeckillQueue() {}

  private static class SingletonHolder {
    /** 静态对象初始化，通过 jvm 来保证线程安全 */
    private static final SeckillQueue queue = new SeckillQueue();
  }

  public static SeckillQueue getQueue() {
    return SingletonHolder.queue;
  }

  /**
   * 入队<br>
   * add(e) 队列未满时，返回 true; 队列满了则抛出 IllegalStateException("Queue full") 异常<br>
   * put(e) 队列未满时，直接插入没有返回值；队列满时会阻塞等待，一直等到队列未满时再插入<br>
   * offer(e) 队列未满时，返回 true; 队列满时返回 false, 非阻塞立即返回<br>
   * offer(e, time, unit) 队列未满时，返回 true; 可设置队列满时的等待时间，如果在指定时间内没有插入成功，直接返回 false
   *
   * @param award
   * @return
   */
  public boolean produce(UserTakeSeckill seckill) {
    return blockingQueue.offer(seckill);
  }

  /**
   * 出队<br>
   * poll(time, unit) 获取并移除队首元素，在指定时间内去轮训队列看队首有没有元素，有则返回，否则超时后返回 null<br>
   * take() 与 poll(time, unit) 方法不同点在于，当队首没有元素时，当前线程会等待，直到其它线程调用 notEmpty.signal() 唤醒
   *
   * @return
   * @throws InterruptedException
   */
  public UserTakeSeckill consume() throws InterruptedException {
    return blockingQueue.take();
  }

  public int size() {
    return blockingQueue.size();
  }
}
