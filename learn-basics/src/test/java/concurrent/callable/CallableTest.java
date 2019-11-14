package concurrent.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * CallableTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class CallableTest {

  ExecutorService executorService;

  @Before
  public void setUp() {
    executorService = Executors.newSingleThreadExecutor();
  }

  @Test
  public void testCallable() throws ExecutionException, InterruptedException {
    FactorialTask task = new FactorialTask(5);
    Future<Integer> future = executorService.submit(task);
    Assertions.assertThat(future.get()).isEqualTo(120);
  }

  @Test(expected = ExecutionException.class)
  public void testException() throws ExecutionException, InterruptedException {
    FactorialTask task = new FactorialTask(-5);
    Future<Integer> future = executorService.submit(task);
    future.get().intValue();
  }

  @Test
  public void testIsDone(){
    FactorialTask task = new FactorialTask(-5);
    Future<Integer> future = executorService.submit(task);
    Assert.assertFalse(future.isDone());
  }

  @After
  public void endUp() {
    executorService.shutdown();
  }
}