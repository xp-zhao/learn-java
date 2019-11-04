package concurrent.mutex;

/**
 * SequenceGeneratorSynchronizedMethod.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class SequenceGeneratorSynchronizedBlock extends SequenceGenerator {

  private Object mutex = new Object();

  @Override
  public int getNextSequence() {
    synchronized (mutex) {
      return super.getNextSequence();
    }
  }
}