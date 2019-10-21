package comparision;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

/**
 * ComparisionTest.java 比较器测试
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
public class ComparisionTest {

  private List<Human> humans;

  @Before
  public void init() {
    humans = Lists.newArrayList(
        new Human("Sarah", 10),
        new Human("Jack", 12));
  }

  @Test
  public void testWithOutLambda() {
    Collections.sort(humans, new Comparator<Human>() {
      @Override
      public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
      }
    });

    Assertions.assertThat(humans.get(0)).isEqualTo(new Human("Jack", 12));
  }

  @Test
  public void testWithLambda() {
//    humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
    humans.sort(Comparator.comparing(Human::getName));
    Assertions.assertThat(humans.get(0)).isEqualTo(new Human("Jack", 12));
  }

  @Test
  public void testWithLambdaReversed() {
    Comparator<Human> comparator = Comparator.comparing(Human::getName);
    humans.sort(comparator.reversed());
    Assertions.assertThat(humans.get(0)).isEqualTo(new Human("Sarah", 10));
  }

  @Test
  public void testCompareByNameThenAge() {
    humans = Lists.newArrayList(
        new Human("Sarah", 12),
        new Human("Sarah", 10),
        new Human("Zack", 12)
    );
//    humans.sort(Human::compareByNameThenAge);
    humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));
    Assertions.assertThat(humans.get(0)).isEqualTo(new Human("Sarah", 10));
  }

  @Test
  public void testStreamSorted() {
    List<String> letters = Lists.newArrayList("B", "A", "C");

//    List<String> sortedLetters = letters.stream().sorted().collect(Collectors.toList());
//    Assertions.assertThat(sortedLetters.get(0)).isEqualTo("A");
    List<String> sortedLetters = letters.stream().sorted(Comparator.reverseOrder())
        .collect(Collectors.toList());
    Assertions.assertThat(sortedLetters.get(0)).isEqualTo("C");
  }


}