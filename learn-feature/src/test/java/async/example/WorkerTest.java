package async.example;

import async.executor.Async;
import async.wrapper.WorkerWrapper;
import java.util.concurrent.ExecutionException;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2023-10-10
 */
public class WorkerTest {
  @Test
  public void testCase1() throws RuntimeException {
    WorkerA workerA = new WorkerA();
    WorkerB workerB = new WorkerB();
    WorkerC workerC = new WorkerC();

    // 编排串行顺序 A -> B -> C
    WorkerWrapper<Integer, Integer> wrapperC =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerC")
            .worker(workerC)
            .callback(workerC)
            .param(3)
            .build();
    WorkerWrapper<Integer, Integer> wrapperB =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerB")
            .worker(workerB)
            .callback(workerB)
            .param(2)
            .next(wrapperC)
            .build();
    WorkerWrapper<Integer, Integer> wrapperA =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerA")
            .worker(workerA)
            .callback(workerA)
            .param(1)
            .next(wrapperB)
            .build();
    try {
      Async.begin(10000, wrapperA);
    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testCase2() throws RuntimeException {
    WorkerA workerA = new WorkerA();
    WorkerB workerB = new WorkerB();
    WorkerC workerC = new WorkerC();

    // 编排串行顺序 A -> B -> C
    WorkerWrapper<Integer, Integer> wrapperA =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerA")
            .worker(workerA)
            .callback(workerA)
            .param(1)
            .build();
    WorkerWrapper<Integer, Integer> wrapperB =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerB")
            .worker(workerB)
            .callback(workerB)
            .param(2)
            .depend(wrapperA)
            .build();
    WorkerWrapper<Integer, Integer> wrapperC =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerC")
            .worker(workerC)
            .callback(workerC)
            .param(3)
            .depend(wrapperB)
            .build();
    try {
      Async.begin(10000, wrapperA);
    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testCase3() {
    WorkerA workerA = new WorkerA();
    WorkerB workerB = new WorkerB();
    WorkerC workerC = new WorkerC();

    // 编排并行顺序
    WorkerWrapper<Integer, Integer> wrapperA =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerA")
            .worker(workerA)
            .callback(workerA)
            .param(1)
            .build();
    WorkerWrapper<Integer, Integer> wrapperB =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerB")
            .worker(workerB)
            .callback(workerB)
            .param(2)
            .build();
    WorkerWrapper<Integer, Integer> wrapperC =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerC")
            .worker(workerC)
            .callback(workerC)
            .param(3)
            .build();
    try {
      Async.begin(10000, wrapperA, wrapperB, wrapperC);
    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testCase4() {
    WorkerA workerA = new WorkerA();
    WorkerB workerB = new WorkerB();
    WorkerC workerC = new WorkerC();

    // 编排先串行后并行顺序，先执行 A，执行完成之后 B,C 并行执行
    WorkerWrapper<Integer, Integer> wrapperB =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerB")
            .worker(workerB)
            .callback(workerB)
            .build();
    WorkerWrapper<Integer, Integer> wrapperC =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerC")
            .worker(workerC)
            .callback(workerC)
            .build();
    WorkerWrapper<Integer, Integer> wrapperA =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerA")
            .worker(workerA)
            .callback(workerA)
            .param(1)
            .next(wrapperB, wrapperC)
            .build();
    try {
      Async.begin(1000, wrapperA);
    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testCase5() {
    WorkerA workerA = new WorkerA();
    WorkerB workerB = new WorkerB();
    WorkerC workerC = new WorkerC();

    // 编排先串行后并行顺序，先执行 A，执行完成之后 B,C 并行执行
    WorkerWrapper<Integer, Integer> wrapperA =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerA")
            .worker(workerA)
            .callback(workerA)
            .param(1)
            .build();
    WorkerWrapper<Integer, Integer> wrapperB =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerB")
            .worker(workerB)
            .callback(workerB)
            .depend(wrapperA)
            .build();
    WorkerWrapper<Integer, Integer> wrapperC =
        new WorkerWrapper.Builder<Integer, Integer>()
            .id("workerC")
            .worker(workerC)
            .callback(workerC)
            .depend(wrapperA)
            .build();
    try {
      Async.begin(1000, wrapperA);
    } catch (ExecutionException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
