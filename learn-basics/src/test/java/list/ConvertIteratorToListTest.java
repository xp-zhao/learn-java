package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ConvertIteratorToListTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class ConvertIteratorToListTest {

  private Iterator<Integer> iterator;

  @Before
  public void init() {
    iterator = Arrays.asList(1, 2, 3).iterator();
  }

  @Test
  public void testLoop() {
    List<Integer> list = new ArrayList<>();
    while (iterator.hasNext()) {
      list.add(iterator.next());
    }
    Assert.assertTrue(list.size() == 3);
  }

  @Test
  public void testForEachRemaining() {
    List<Integer> list = new ArrayList<>();
    iterator.forEachRemaining(list::add);
    Assert.assertTrue(list.size() == 3);
  }

  @Test
  public void testStreamSupport() {
    Iterable<Integer> iterable = () -> iterator;
    List<Integer> list = StreamSupport
        .stream(iterable.spliterator(), false)
        .collect(Collectors.toList());
    Assert.assertTrue(list.size() == 3);
  }

}