package concurrent.future.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.logging.Logger;

/**
 * CustomRecursiveAction.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/11
 **/
public class CustomRecursiveAction extends RecursiveAction {

  private static Logger logger = Logger.getAnonymousLogger();

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
    String partTwo = workload.substring(workload.length() / 2);

    subtasks.add(new CustomRecursiveAction(partOne));
    subtasks.add(new CustomRecursiveAction(partTwo));

    return subtasks;
  }

  private void processing(String work) {
    String result = work.toUpperCase();
    logger.info("This result - (" + result + ") - was processed by "
        + Thread.currentThread().getName());
  }
}