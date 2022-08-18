package concurrent.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/8/18
 */
public class CustomRecursiveAction extends RecursiveAction {

  private String workload = "";
  private static final int THRESHOLD = 4;

  public CustomRecursiveAction(String workload) {
    this.workload = workload;
  }

  @Override
  protected void compute() {
    if (workload.length() > THRESHOLD) {
      ForkJoinTask.invokeAll(createSubtasks());
    } else {
      processing(workload);
    }
  }

  private List<CustomRecursiveAction> createSubtasks() {
    List<CustomRecursiveAction> subtasks = new ArrayList<>();

    String partOne = workload.substring(0, workload.length() / 2);
    String partTwo = workload.substring(workload.length() / 2, workload.length());

    subtasks.add(new CustomRecursiveAction(partOne));
    subtasks.add(new CustomRecursiveAction(partTwo));

    return subtasks;
  }

  private void processing(String work) {
    String result = work.toUpperCase();
    System.out.println(
        "This result - (" + result + ") - was processed by " + Thread.currentThread().getName());
  }

  public static void main(String[] args) throws InterruptedException {
    ForkJoinPool forkJoinPool = new ForkJoinPool();
    forkJoinPool.submit(new CustomRecursiveAction("abcdefghij"));
    forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
    forkJoinPool.shutdown();
  }
}
