package org.example.loadbalance;

import java.util.List;
import java.util.Random;
import org.example.common.URL;

/**
 * @author zhaoxiaoping
 * @date 2023-10-10
 */
public class LoadBalance {
  public static URL random(List<URL> urls) {
    Random random = new Random();
    int i = random.nextInt(urls.size());
    return urls.get(i);
  }
}
