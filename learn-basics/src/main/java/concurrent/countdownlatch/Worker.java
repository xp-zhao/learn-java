package concurrent.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Worker.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/08
 **/
public class Worker implements Runnable {

  private List<String> outputList;
  private CountDownLatch countDownLatch;

  public Worker(List<String> outputList, CountDownLatch countDownLatch) {
    this.outputList = outputList;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    outputList.add("Counted down");
    countDownLatch.countDown();
  }
}