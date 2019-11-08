package concurrent.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

/**
 * CountDownLatchTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/08
 **/
public class CountDownLatchTest {

  @Test
  public void testWaitingWorker() throws InterruptedException {
    List<String> outputList = new ArrayList<>();
    CountDownLatch readyThreadCounter = new CountDownLatch(5);
    CountDownLatch callingThreadCounter = new CountDownLatch(1);
    CountDownLatch completedThreadCounter = new CountDownLatch(5);
    List<Thread> workers = Stream.generate(() -> new Thread(
        new WatingWorker(outputList, readyThreadCounter, callingThreadCounter,
            completedThreadCounter)))
        .limit(5)
        .collect(Collectors.toList());

    workers.forEach(Thread::start);
    readyThreadCounter.await();
    outputList.add("Workers ready");
    callingThreadCounter.countDown();
    completedThreadCounter.await();
    outputList.add("Workers complete");
    Assert.assertTrue(outputList.get(0).equals("Workers ready"));
    Assert.assertTrue(outputList.get(outputList.size() - 1).equals("Workers complete"));
  }

  @Test
  public void testBrokenWorker() throws InterruptedException {
    List<String> outputList = new ArrayList<>();
    CountDownLatch countDownLatch = new CountDownLatch(5);

    List<Thread> workers = Stream
        .generate(() -> new Thread(new BrokenWorker(outputList, countDownLatch)))
        .limit(5)
        .collect(Collectors.toList());
    workers.forEach(Thread::start);
    boolean completed =  countDownLatch.await(3L, TimeUnit.SECONDS);
    Assertions.assertThat(completed).isFalse();
  }
}