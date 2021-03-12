package monitor;

import cn.hutool.core.date.StopWatch;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

/**
 * @author zhaoxiaoping
 * @Description: 耗时监控处理
 * @Date 2021-3-12
 **/
public class WatchHandler {

  public static <T> T run(StopWatch stopWatch, String taskName, Supplier<T> supplier) {
    try {
      stopWatch.start(taskName);
      return supplier.get();
    } finally {
      stopWatch.stop();
    }
  }

  public static void run(StopWatch stopWatch, String taskName, IntConsumer consumer) {
    try {
      stopWatch.start(taskName);
      consumer.accept(0);
    } finally {
      stopWatch.stop();
    }
  }
  
}
