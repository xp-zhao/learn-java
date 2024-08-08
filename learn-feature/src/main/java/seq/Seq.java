package seq;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author zhaoxiaoping
 * @date 2023-4-25
 */
public interface Seq<T> {
  void consume(Consumer<T> consumer);

  default <T> Seq<T> unit(T t) {
    return c -> c.accept(t);
  }

  default <E> Seq<E> map(Function<T, E> function) {
    return c -> consume(t -> c.accept(function.apply(t)));
  }

  default <E> Seq<E> flatMap(Function<T, Seq<E>> function) {
    return c -> consume(t -> function.apply(t).consume(c));
  }

  default Seq<T> filter(Predicate<T> predicate) {
    return c ->
        consume(
            t -> {
              if (predicate.test(t)) {
                c.accept(t);
              }
            });
  }

  default <T> Seq<T> take(int n) {
    return c -> {
      int[] i = {n};
      consumeTillStop(
          t -> {
            if (i[0]-- > 0) {
              c.accept((T) t);
            } else {
              stop();
            }
          });
    };
  }

  default Seq<T> drop(int n) {
    return c -> {
      int[] i = {n - 1};
      consume(
          t -> {
            if (i[0] < 0) {
              c.accept(t);
            } else {
              i[0]--;
            }
          });
    };
  }

  default Seq<T> onEach(Consumer<T> consumer) {
    return c -> consume(consumer.andThen(c));
  }

  default void consumeTillStop(Consumer<T> consumer) {
    try {
      consume(consumer);
    } catch (StopException ignore) {
    }
  }

  default String join(String sep) {
    StringJoiner joiner = new StringJoiner(sep);
    consume(t -> joiner.add(t.toString()));
    return joiner.toString();
  }

  default List<T> toList() {
    List<T> list = new ArrayList<>();
    consume(list::add);
    return list;
  }

  static <T> T stop() {
    throw StopException.INSTANCE;
  }
}
