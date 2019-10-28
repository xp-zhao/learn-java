package list;

import static org.assertj.core.data.MapEntry.entry;

import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

/**
 * CountDuplicateElementsTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/28
 **/
public class CountDuplicateElementsTest {

  private List<String> list;

  @Before
  public void init() {
    list = Lists.list(
        "expect1",
        "expect2", "expect2",
        "expect3", "expect3", "expect3",
        "expect4", "expect4", "expect4", "expect4");
  }

  @Test
  public void testLoopMapPut() {
    Map<String, Long> map = CountDuplicateElements.countByClassicalLoop(list);
    Assertions.assertThat(map).isNotEmpty().hasSize(4).containsExactly(
        entry("expect1", 1L),
        entry("expect2", 2L),
        entry("expect3", 3L),
        entry("expect4", 4L));
  }

  @Test
  public void testLoopMapCompute() {
    Map<String, Long> map = CountDuplicateElements.countByClassicalLoopMapCompute(list);
    Assertions.assertThat(map).isNotEmpty().hasSize(4).containsExactly(
        entry("expect1", 1L),
        entry("expect2", 2L),
        entry("expect3", 3L),
        entry("expect4", 4L));
  }

  @Test
  public void testStreamCollectorToMap() {
    Map<String, Long> map = CountDuplicateElements.countByStreamToMap(list);
    Assertions.assertThat(map).isNotEmpty().hasSize(4).containsExactly(
        entry("expect1", 1L),
        entry("expect2", 2L),
        entry("expect3", 3L),
        entry("expect4", 4L));
  }

  @Test
  public void testStreamCollectorGroupBy() {
    Map<String, Long> map = CountDuplicateElements.countByStreamGroupBy(list);
    Assertions.assertThat(map).isNotEmpty().hasSize(4).containsExactly(
        entry("expect1", 1L),
        entry("expect2", 2L),
        entry("expect3", 3L),
        entry("expect4", 4L));
  }
}