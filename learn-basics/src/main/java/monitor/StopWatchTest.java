package monitor;

import cn.hutool.core.date.StopWatch;
import cn.hutool.core.date.StopWatch.TaskInfo;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @Description: 代码执行耗时测试
 * @Date 2021-3-12
 **/
public class StopWatchTest {

  public static void main(String[] args) throws InterruptedException {
    StopWatch watch = new StopWatch();
    watch.start("task1");
    TimeUnit.SECONDS.sleep(1);
    watch.stop();
    watch.start("task2");
    TimeUnit.SECONDS.sleep(1);
    watch.stop();
    TaskInfo[] list = watch.getTaskInfo();
    for (TaskInfo task : list) {
      System.out.println(task.getTaskName()+":"+task.getTimeSeconds());
    }
  }
}
