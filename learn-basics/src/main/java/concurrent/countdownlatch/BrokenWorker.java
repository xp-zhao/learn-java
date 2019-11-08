package concurrent.countdownlatch;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * BrokenWorker.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/08
 **/
public class BrokenWorker implements Runnable {

  private final List<String> outputList;
  private final CountDownLatch countDownLatch;

  public BrokenWorker(List<String> outputList, CountDownLatch countDownLatch) {
    this.outputList = outputList;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    if(true){
      throw new RuntimeException("error");
    }
    countDownLatch.countDown();
    outputList.add("Counted donw");
  }
}