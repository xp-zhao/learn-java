package random;

import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * RandomLong.java Generate a Long Data
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
public class RandomLong {

  public static void main(String[] args) {
    randomLongUnbounded();
    randomLongBounded();
  }

  /**
   * Generate an Unbounded Long
   */
  public static void randomLongUnbounded() {
    System.out.println(new Random().nextLong());
  }

  /**
   * Generate a Long within a Range
   */
  public static void randomLongBounded() {
    long leftLimit = 1L;
    long rightLimit = 10L;
    // Random Long with Plain Java
    System.out.println(leftLimit + (Math.random() * (rightLimit - leftLimit)));
    // Random Long with Apache Commons Math
    System.out.println(new RandomDataGenerator().nextLong(leftLimit, rightLimit));
  }

}