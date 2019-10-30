package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FilterStreamOfOptional.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class FilterStreamOfOptional {

  public static void main(String[] args) {
    List<Optional<String>> listOfOptionals = Arrays.asList(
        Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar")
    );

    filterByFilter(listOfOptionals);

    fileterByFlatMap(listOfOptionals);
  }

  private static void fileterByFlatMap(List<Optional<String>> listOfOptionals) {
    List<String> filteredList = listOfOptionals.parallelStream()
        .flatMap(item -> item.map(Stream::of).orElseGet(Stream::empty))
        .collect(Collectors.toList());
    System.out.println(filteredList);
  }

  private static void filterByFilter(List<Optional<String>> listOfOptionals) {
    List<String> filteredList = listOfOptionals.stream()
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());
    System.out.println(filteredList);
  }


}