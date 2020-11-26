package generic;

/**
 * @author zhaoxiaoping
 * @Description: 元组
 * @Date 2020-11-25
 **/
public class Tuple<F, S> {

  public F first;
  public S second;

  public Tuple(F f, S s) {
    this.first = f;
    this.second = s;
  }

  public F getFirst() {
    return first;
  }

  public S getSecond() {
    return second;
  }

  @Override
  public String toString() {
    return "Tuple{" +
        "first=" + first +
        ", second=" + second +
        '}';
  }
}
