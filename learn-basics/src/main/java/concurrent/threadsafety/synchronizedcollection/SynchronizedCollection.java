package concurrent.threadsafety.synchronizedcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * SynchronizedCollection.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/07
 **/
public class SynchronizedCollection {

  public static void main(String[] args) throws InterruptedException {
    Collection<Integer> collection = new ArrayList<>();
    Thread thread1 = new Thread(() -> collection.addAll(Arrays.asList(1, 2, 3, 4, 5)));
    Thread thread2 = new Thread(() -> collection.addAll(Arrays.asList(6, 7, 8, 9, 10)));
    thread1.start();
    thread2.start();
    TimeUnit.SECONDS.sleep(1L);
    System.out.println(collection);
  }
}