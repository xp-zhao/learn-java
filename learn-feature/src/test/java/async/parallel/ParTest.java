package async.parallel;

import async.executor.Async;
import async.executor.timer.SystemClock;
import async.wrapper.WorkerWrapper;
import java.util.concurrent.ExecutionException;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2023-7-3
 */
public class ParTest {

  /**
   * worker1, worker2, worker3 三个并行
   *
   * @throws ExecutionException
   * @throws InterruptedException
   */
  @Test
  public void testNormal() throws ExecutionException, InterruptedException {
    ParWorker1 worker1 = new ParWorker1();
    ParWorker2 worker2 = new ParWorker2();
    ParWorker3 worker3 = new ParWorker3();
    WorkerWrapper wrapper1 =
        new WorkerWrapper.Builder<String, String>()
            .worker(worker1)
            .callback(worker1)
            .param("1")
            .build();
    WorkerWrapper wrapper2 =
        new WorkerWrapper.Builder<String, String>()
            .worker(worker2)
            .callback(worker2)
            .param("2")
            .build();
    WorkerWrapper wrapper3 =
        new WorkerWrapper.Builder<String, String>()
            .worker(worker3)
            .callback(worker3)
            .param("3")
            .build();
    long now = SystemClock.now();
    System.out.println("begin-" + now);

    Async.begin(1500, wrapper1, wrapper2, wrapper3);

    System.out.println("end-" + SystemClock.now());
    System.err.println("cost-" + (SystemClock.now() - now));
    System.out.println(Async.getThreadCount());

    System.out.println(wrapper1.getWorkResult());
    Async.shutDown();
  }

  @Test
  public void testMulti() throws ExecutionException, InterruptedException {
    ParWorker1 worker1 = new ParWorker1();
    ParWorker2 worker2 = new ParWorker2();
    ParWorker3 worker3 = new ParWorker3();
    WorkerWrapper wrapper3 =
        new WorkerWrapper.Builder<String, String>()
            .worker(worker3)
            .callback(worker3)
            .param("3")
            .build();
    WorkerWrapper wrapper1 =
        new WorkerWrapper.Builder<String, String>()
            .worker(worker1)
            .callback(worker1)
            .param("1")
            .next(wrapper3)
            .build();
    ;
    WorkerWrapper wrapper2 =
        new WorkerWrapper.Builder<String, String>()
            .worker(worker2)
            .callback(worker2)
            .param("2")
            .build();

    wrapper1.addNext(wrapper3);

    long now = SystemClock.now();
    System.out.println("begin-" + now);

    Async.begin(2500, wrapper1, wrapper2);

    System.out.println("end-" + SystemClock.now());
    System.err.println("cost-" + (SystemClock.now() - now));
    System.out.println(Async.getThreadCount());

    System.out.println(wrapper1.getWorkResult());
    Async.shutDown();
  }
}
