package vavr.functions;

import io.vavr.Function0;
import io.vavr.Function2;

/**
 * function 示例
 *
 * @author zhaoxiaoping
 * @date 2022-8-15
 */
public class FunctionExample {
  public static void main(String[] args) {
    Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
    System.out.println(sum.apply(1, 1));
    Function0<Double> randomCache = Function0.of(Math::random).memoized();
    System.out.println(randomCache.isMemoized());
    System.out.println(randomCache.apply());
    System.out.println(randomCache.apply());
  }
}
