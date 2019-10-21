package random;

import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * RandomDouble.java Generate a Double Data
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
public class RandomDouble {

  public static void main(String[] args) {
    randomDoubleUnbounded();
    randomDoubleBounded();
  }

  /**
   * Generate an Unbound Double
   */
  public static void randomDoubleUnbounded() {
    // Random Unbounded Double with Plain Java
    System.out.println(Math.random());
    // Random Unbounded Double with Commons Math
    System.out.println(new RandomDataGenerator().getRandomGenerator().nextDouble());
  }

  /**
   * Generate a Double Within a Range
   */
  public static void randomDoubleBounded() {
    double leftLimit = 1D;
    double rightLimit = 10D;
    // Random Bounded Double with Plain Java
    System.out.println(leftLimit + new Random().nextDouble() * (rightLimit - leftLimit));
    // Random Bounded Double with Commons Math
    System.out.println(new RandomDataGenerator().nextUniform(leftLimit, rightLimit));
  }
}