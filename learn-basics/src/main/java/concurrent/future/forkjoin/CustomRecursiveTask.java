package concurrent.future.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * CustomRecursiveTask.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/11
 **/
public class CustomRecursiveTask extends RecursiveTask<Integer> {

  private int[] arr;

  private static final int THRESHOLD = 20;

  public CustomRecursiveTask(int[] arr) {
    this.arr = arr;
  }

  @Override
  protected Integer compute() {
    if (arr.length > THRESHOLD) {
      return ForkJoinTask.invokeAll(createSubtasks())
          .stream()
          .mapToInt(ForkJoinTask::join)
          .sum();
    } else {
      return processing(arr);
    }
  }

  private Collection<CustomRecursiveTask> createSubtasks() {
    List<CustomRecursiveTask> taskList = new ArrayList<>();
    taskList.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, 0, arr.length / 2)));
    taskList.add(new CustomRecursiveTask(Arrays.copyOfRange(arr, arr.length / 2, arr.length)));
    return taskList;
  }

  private Integer processing(int[] arr) {
    return Arrays.stream(arr)
        .filter(a -> a > 10 && a < 27)
        .map(a -> a * 10)
        .sum();
  }
}