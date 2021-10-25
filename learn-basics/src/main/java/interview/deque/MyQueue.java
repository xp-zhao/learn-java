package interview.deque;

import java.util.LinkedList;

/** @author zhaoxiaoping @Description: 自定义队列 @Date 2021-10-25 */
public class MyQueue {
  private static final int MAX_SIZE = 100;
  private LinkedList<String> queue = new LinkedList<>();

  public synchronized void offer(String element) {
    try {
      if (queue.size() == MAX_SIZE) {
        // 队列已满, 让当前添加元素的线程进入等待的状态, 同时释放掉锁
        wait();
      }
      queue.addLast(element);
      notifyAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public synchronized String take() {
    String element = null;
    try {
      if (queue.size() == 0) {
        // 队列是空的, 让当前获取元素的线程进入等待状态, 同时释放掉锁
        wait();
      }
      element = queue.removeLast();
      notifyAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return element;
  }
}
