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
    WorkerWrapper wrapper1 = new WorkerWrapper(worker1, "1", worker1);
    WorkerWrapper wrapper2 = new WorkerWrapper(worker2, "2", worker2);
    WorkerWrapper wrapper3 = new WorkerWrapper(worker3, "3", worker3);
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
    WorkerWrapper wrapper1 = new WorkerWrapper(worker1, "1", worker1);
    WorkerWrapper wrapper2 = new WorkerWrapper(worker2, "2", worker2);
    WorkerWrapper wrapper3 = new WorkerWrapper(worker3, "3", worker3);

    wrapper1.addNext(wrapper3);

    long now = SystemClock.now();
    System.out.println("begin-" + now);

    Async.begin(1500, wrapper1, wrapper2);

    System.out.println("end-" + SystemClock.now());
    System.err.println("cost-" + (SystemClock.now() - now));
    System.out.println(Async.getThreadCount());

    System.out.println(wrapper1.getWorkResult());
    Async.shutDown();
  }
}
