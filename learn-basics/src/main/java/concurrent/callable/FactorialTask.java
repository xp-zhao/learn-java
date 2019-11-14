package concurrent.callable;

import java.security.InvalidParameterException;
import java.util.concurrent.Callable;

/**
 * FactorialTask.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class FactorialTask implements Callable<Integer> {

  int number;

  public FactorialTask(int number) {
    this.number = number;
  }

  @Override
  public Integer call() throws InvalidParameterException {
    if (number < 0) {
      throw new InvalidParameterException("Number should be positive");
    }
    int fact = 1;
    for (int count = number; count > 1; count--) {
      fact = fact * count;
    }
    return fact;
  }
}