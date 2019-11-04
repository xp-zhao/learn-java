package concurrent.mutex;

import com.google.common.util.concurrent.Monitor;

/**
 * SequenceGeneratorSynchronizedMethod.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class SequenceGeneratorGuavaMonitor extends SequenceGenerator {

  private Monitor mutex = new Monitor();

  @Override
  public int getNextSequence() {
    mutex.enter();
    try {
      return super.getNextSequence();
    } finally {
      mutex.leave();
    }
  }
}