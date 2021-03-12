package monitor;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.date.StopWatch.TaskInfo;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-3-12
 **/
public class WatchHandlerTest {

  public static void main(String[] args) {
    StopWatch watch = new StopWatch();
    WatchHandler.run(watch, "task1", i -> {
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    WatchHandler.run(watch, "task2", () -> {
      try {
        TimeUnit.SECONDS.sleep(1);
        return "yes";
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return "no";
    });
    for (TaskInfo task : watch.getTaskInfo()) {
      System.out.println(task.getTaskName()+":"+task.getTimeMillis());
    }
  }
}
