package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * RemoveElementTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class RemoveElementTest {

  private List<String> sports;

  @Before
  public void init() {
    sports = new ArrayList<>();
    sports.add("Football");
    sports.add("Basketball");
    sports.add("Baseball");
    sports.add("Boxing");
    sports.add("Cycling");
  }

  @Test
  public void testRemoveByIndex() {
    String result = sports.remove(1);
    Assertions.assertThat(result).isEqualTo("Basketball");
    Assertions.assertThat(sports.size()).isEqualTo(4);
    Assertions.assertThat(sports.get(1)).isNotEqualTo("Basketball");
  }

  @Test
  public void testRemoveByElement() {
    sports.remove("Basketball");
    Assertions.assertThat(sports.size()).isEqualTo(4);
    Assertions.assertThat(sports.contains("Basketball")).isFalse();
  }

  @Test
  public void testRemoveByIterator() {
    Iterator<String> iterator = sports.iterator();
    while (iterator.hasNext()) {
      if (iterator.next().equals("Boxing")) {
        iterator.remove();
      }
    }
    Assertions.assertThat(sports.contains("Boxing")).isFalse();
  }

  @Test
  public void testRemoveIf() {
    sports.removeIf(p -> p.equals("Cycling"));
    Assertions.assertThat(sports.size()).isEqualTo(4);
    Assertions.assertThat(sports.contains("Cycling")).isFalse();
    Assert.assertFalse(sports.contains("Cycling"));
  }
}