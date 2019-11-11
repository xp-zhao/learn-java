package concurrent.future.forkjoin;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * ForkJoinTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/11
 **/
public class ForkJoinTest {

  @Test
  public void testCustomRecursiveAction() {
    CustomRecursiveAction action = new CustomRecursiveAction("aabbccddeeff");
    ForkJoinPool.commonPool().invoke(action);
    System.out.println(action.isDone());
  }

  @Test
  public void testCustomRecursiveTask() throws ExecutionException, InterruptedException {
    Random random = new Random();
    int[] arr = new int[50];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(35);
    }
    CustomRecursiveTask task = new CustomRecursiveTask(arr);
    ForkJoinPool.commonPool().execute(task);

    Assertions.assertThat(task.get()).isEqualTo(task.join());

    ForkJoinPool.commonPool().submit(task);
    Assertions.assertThat(task.get()).isEqualTo(task.join());
  }
}