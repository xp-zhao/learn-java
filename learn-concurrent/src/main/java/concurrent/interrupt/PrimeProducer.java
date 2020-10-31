package concurrent.interrupt;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhaoxiaoping
 * @Description: 素数打印
 * @Date 2020-10-24
 **/
public class PrimeProducer extends Thread {

  private final BlockingQueue<BigInteger> queue;

  PrimeProducer(BlockingQueue<BigInteger> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      BigInteger p = BigInteger.ZERO;
      while (!Thread.currentThread().isInterrupted()) {
        queue.put(p.nextProbablePrime());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public void cancel() {
    interrupt();
  }
}
