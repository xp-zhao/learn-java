package core.random;

import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * RandomFloat.java Generate a Float Data
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
public class RandomFloat {

  public static void main(String[] args) {
    randomFloatUnbounded();
    randomFloatBounded();
  }

  /**
   * Generate an Unbound Float
   */
  public static void randomFloatUnbounded() {
    System.out.println(new Random().nextFloat());
  }

  /**
   * Generate a Float within a Range
   */
  public static void randomFloatBounded() {
    float leftLimit = 1F;
    float rightLimit = 10F;
    // Random Float with Plain Java
    System.out.println(leftLimit + new Random().nextFloat() * (rightLimit - leftLimit));
    // Random Float with Commons Math
    float randomFloat = new RandomDataGenerator().getRandomGenerator().nextFloat();
    System.out.println(leftLimit + randomFloat * (rightLimit - leftLimit));
  }
}