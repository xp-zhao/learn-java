package vavr.tuples;

import io.vavr.Tuple;
import io.vavr.Tuple2;

/**
 * 元组示例
 *
 * @author zhaoxiaoping
 * @date 2022-8-15
 */
public class TupleExample {
  public static void main(String[] args) {
    Tuple2<String, String> tuple = Tuple.of("a", "b");
    System.out.println(tuple._1);
    System.out.println(tuple._2);
    Tuple2<String, String> r1 = tuple.map(f -> f + "_f", s -> s + "_s");
    System.out.println(r1);
    Tuple2<String, String> r2 = tuple.map((f, s) -> Tuple.of(f + "_f", s + "_s"));
    System.out.println(r2);
    String r3 = tuple.apply((f, s) -> f + "_" + s);
    System.out.println(r3);
  }
}
