package concurrent.mutex;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;

/**
 * SequenceGeneratorTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/04
 **/
public class SequenceGeneratorTest {

  @Test
  public void testRaceCondition() throws Exception {
    int count = 100000;
    Set<Integer> set = getUniqueSequences(new SequenceGenerator(), count);
    Assert.assertEquals(count, set.size());
  }

  @Test
  public void testSynchronizedMethod() throws Exception {
    int count = 100000;
    Set<Integer> set = getUniqueSequences(new SequenceGeneratorSynchronizedMethod(), count);
    Assert.assertEquals(count, set.size());
  }

  @Test
  public void testSynchronizedBlock() throws Exception {
    int count = 100000;
    Set<Integer> set = getUniqueSequences(new SequenceGeneratorSynchronizedBlock(), count);
    Assert.assertEquals(count, set.size());
  }

  @Test
  public void testReentrantLock() throws Exception {
    int count = 100000;
    Set<Integer> set = getUniqueSequences(new SequenceGeneratorReentrantLock(), count);
    Assert.assertEquals(count, set.size());
  }

  @Test
  public void testSemaphore() throws Exception {
    int count = 100000;
    Set<Integer> set = getUniqueSequences(new SequenceGeneratorSemaphore(), count);
    Assert.assertEquals(count, set.size());
  }

  @Test
  public void testGuavaMonitor() throws Exception {
    int count = 100000;
    Set<Integer> set = getUniqueSequences(new SequenceGeneratorGuavaMonitor(), count);
    Assert.assertEquals(count, set.size());
  }

  private Set<Integer> getUniqueSequences(SequenceGenerator generator, int count)
      throws Exception {
    ExecutorService service = Executors.newFixedThreadPool(3);
    Set<Integer> uniqueSequences = new LinkedHashSet<>();
    List<Future<Integer>> futures = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      futures.add(service.submit(generator::getNextSequence));
    }

    for (Future<Integer> future : futures) {
      uniqueSequences.add(future.get());
    }

    service.awaitTermination(1, TimeUnit.SECONDS);
    service.shutdown();
    return uniqueSequences;
  }
}