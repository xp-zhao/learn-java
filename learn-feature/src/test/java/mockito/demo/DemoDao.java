package mockito.demo;

import java.util.Random;

/**
 * @author zhaoxiaoping
 * @date 2024-3-28
 */
public class DemoDao {
  public int getRandomCount() {
    return new Random().nextInt();
  }
}
