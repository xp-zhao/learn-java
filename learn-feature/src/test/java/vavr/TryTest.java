package vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Try;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.vavr.control.Validation;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2024-4-26
 */
public class TryTest {

  @Test
  public void testTry() {
    List<Integer> numbers = Arrays.asList(10, 0, 5, 2);
    List<Try<Integer>> results = numbers.stream().map(this::divide).collect(Collectors.toList());

    results.forEach(
        r ->
            r.onSuccess(System.out::println)
                .onFailure(t -> System.out.println("Error: " + t.getMessage())));
  }

  @Test
  public void testValidation() {
    Validation<List<String>, Tuple2<String, Integer>> validationResult = validateUser("xp", 20);
    validationResult.fold(
        errors -> {
          System.out.println("Errors: " + errors);
          return null;
        },
        t -> {
          System.out.println("xx");
          return null;
        });
  }

  public Try<Integer> divide(int a) {
    return Try.of(() -> 10 / a);
  }

  public Validation<List<String>, Tuple2<String, Integer>> validateUser(String name, int age) {
    List<String> errors = new ArrayList<>();
    if (name == null || name.trim().isEmpty()) {
      errors.add("Name is required");
    }
    if (age < 0) {
      errors.add("Age must be non-negative");
    }
    if (errors.isEmpty()) {
      return Validation.valid(new Tuple2<>(name, age));
    } else {
      return Validation.invalid(errors);
    }
  }
}
