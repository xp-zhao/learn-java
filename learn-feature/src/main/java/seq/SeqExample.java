package seq;

import one.util.streamex.StreamEx;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @date 2023-4-25
 */
public class SeqExample {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3);
    StreamEx.of(list);
    Seq<Integer> seq = list::forEach;
    System.out.println(seq.join(","));
    seq.consume(System.out::println);
    System.out.println(seq);
    seq.unit(1).consume(System.out::println);
    seq.map(item -> item + 1).consume(System.out::println);
  }
}
