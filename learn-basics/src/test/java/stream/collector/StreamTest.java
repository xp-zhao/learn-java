package stream.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * StreamTest.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class StreamTest {

  private List<Book> bookList;

  @Before
  public void setUp() {
    bookList = new ArrayList<>();
    bookList.add(new Book("The Fellowship of the Ring", 1954, "0395489318"));
    bookList.add(new Book("The Two Towers", 1954, "0345339711"));
    bookList.add(new Book("The Return of the King", 1955, "0618129111"));
  }

  @Test(expected = IllegalStateException.class)
  public void testToMapDupKeyError() {
    Map<Integer, Book> map = bookList.stream()
        .collect(Collectors.toMap(Book::getReleaseYear, k -> k));
    map.forEach((k, v) -> System.out.println(k + ": " + v));
  }

  @Test
  public void testToMapDupKey() {
    Map<Integer, Book> map = bookList.stream()
        .collect(Collectors.toMap(Book::getReleaseYear, Function.identity(), (k1, k2) -> k1));
    map.forEach((k, v) -> System.out.println(k + ": " + v));
  }

  @Test
  public void testListToConcurrentMap() {
    Map<Integer, Book> map = bookList.stream()
        .collect(Collectors.toMap(Book::getReleaseYear, Function.identity(),
            (o1, o2) -> o1, ConcurrentHashMap::new));
    Assert.assertTrue(map instanceof ConcurrentHashMap);
  }

  @Test
  public void testToSortedMap() {
    TreeMap<String, Book> map = bookList.stream()
        .sorted(Comparator.comparing(Book::getName))
        .collect(
            Collectors.toMap(Book::getName, Function.identity(), (o1, o2) -> o1, TreeMap::new));
    System.out.println(map.firstKey());
  }

  @Test
  public void testStreamOf() {
    int[] array = new int[]{1, 2, 3, 4};
    Arrays.stream(array).forEach(i -> System.out.println(i));
    Stream.of(array).flatMapToInt(Arrays::stream).forEach(System.out::println);
  }
}