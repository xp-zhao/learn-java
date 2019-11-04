package concurrent.mutex;

/**
 * SequenceGeneratorSynchronizedMethod.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class SequenceGeneratorSynchronizedMethod extends SequenceGenerator {

  @Override
  public synchronized int getNextSequence() {
    return super.getNextSequence();
  }
}