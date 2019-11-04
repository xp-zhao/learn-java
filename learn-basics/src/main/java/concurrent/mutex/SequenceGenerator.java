package concurrent.mutex;

/**
 * SequenceGenerator.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class SequenceGenerator {

  private int currentValue = 0;

  public int getNextSequence(){
    currentValue = currentValue + 1;
    return currentValue;
  }
}