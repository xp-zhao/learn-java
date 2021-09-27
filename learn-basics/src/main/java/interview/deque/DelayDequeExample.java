package interview.deque;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/** @author zhaoxiaoping @Description: 延迟队列示例 @Date 2021-9-27 */
@Slf4j
public class DelayDequeExample {

  public static void main(String[] args) throws InterruptedException {
    DelayQueue<DelayExample> delayQueue = new DelayQueue<DelayExample>();
    delayQueue.offer(new DelayExample("aaa", 5, TimeUnit.SECONDS));
    delayQueue.offer(new DelayExample("ccc", 1, TimeUnit.SECONDS));
    delayQueue.offer(new DelayExample("bbb", 3, TimeUnit.SECONDS));
    log.info(delayQueue.take().getStr());
    log.info(delayQueue.take().getStr());
    log.info(delayQueue.take().getStr());
  }

  static class DelayExample implements Delayed {
    private String str;
    private long time;

    public DelayExample(String str, long time, TimeUnit timeUnit) {
      this.str = str;
      this.time = System.currentTimeMillis() + (time > 0 ? timeUnit.toMillis(time) : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
      return time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
      DelayExample example = (DelayExample) o;
      long diff = this.time - example.time;
      if (diff < 0) {
        return -1;
      } else {
        return 1;
      }
    }

    public String getStr() {
      return str;
    }
  }
}
