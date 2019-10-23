package timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * SchedulingTask.java Schedule a Task Once
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/22
 **/
public class SchedulingTask {

  public static void main(String[] args) throws InterruptedException {
//    standardTask();
//    repeatedTask();
    executorServiceTask();
  }

  private static void standardTask() throws InterruptedException {
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        System.out.println(
            "Task performed on: " + LocalDateTime.now() + "n" + "Thread's name: " +
                Thread.currentThread().getName());
//        cancel();
      }
    };
    Timer timer = new Timer("timer");
    long delay = 1000L;
    timer.schedule(task, delay);
//    timer.cancel();
    TimeUnit.SECONDS.sleep(6);
  }

  public static void repeatedTask() {
    TimerTask repeatedTask = new TimerTask() {
      @Override
      public void run() {
        System.out.println("Task performed on " + LocalDateTime.now());
      }
    };
    Timer timer = new Timer("timer");

    long delay = 1000L;
    long period = 1000L;
    timer.scheduleAtFixedRate(repeatedTask, delay, period);
  }

  public static void executorServiceTask() throws InterruptedException {
    TimerTask repeatedTask = new TimerTask() {
      @Override
      public void run() {
        System.out.println("Task performed on " + LocalDateTime.now());
      }
    };
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    long delay = 1000L;
    long period = 1000L;
    executor.scheduleAtFixedRate(repeatedTask, delay, period, TimeUnit.MILLISECONDS);
    TimeUnit.SECONDS.sleep(6);
    executor.shutdown();
  }
}