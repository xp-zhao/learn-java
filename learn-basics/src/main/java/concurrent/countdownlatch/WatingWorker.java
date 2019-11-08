package concurrent.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * WatingWorker.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/08
 **/
public class WatingWorker implements Runnable {

  private List<String> outputList;
  private CountDownLatch readyThreadCounter;
  private CountDownLatch callingThreadCounter;
  private CountDownLatch completedThreadCounter;

  public WatingWorker(List<String> outputList, CountDownLatch readyThreadCounter,
      CountDownLatch callingThreadCounter, CountDownLatch completedThreadCounter) {
    this.outputList = outputList;
    this.readyThreadCounter = readyThreadCounter;
    this.callingThreadCounter = callingThreadCounter;
    this.completedThreadCounter = completedThreadCounter;
  }

  @Override
  public void run() {
    readyThreadCounter.countDown();
    try {
      callingThreadCounter.await();
      outputList.add("Counted down");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      completedThreadCounter.countDown();
    }
  }
}