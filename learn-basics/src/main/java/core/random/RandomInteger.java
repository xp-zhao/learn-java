package core.random;

import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * RandomInteger.java Generate an Integer Data
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
public class RandomInteger {

  public static void main(String[] args) {
    randomIntegerUnbounded();
    randomIntegerBounded();
  }

  /**
   * Generate an Unbounded Integer
   */
  public static void randomIntegerUnbounded() {
    System.out.println(new Random().nextInt());
  }

  /**
   * Generate an Integer within a Range
   */
  public static void randomIntegerBounded() {
    int leftLimit = 1;
    int rightLimit = 10;
    // Random Integer with Plain Java
    System.out.println(leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit)));
    // Random Integer with Apache Commons Math
    System.out.println(new RandomDataGenerator().nextInt(leftLimit, rightLimit));
  }
}
