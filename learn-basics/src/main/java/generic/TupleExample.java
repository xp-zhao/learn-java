package generic;

/**
 * @author zhaoxiaoping
 * @Description: 泛型实现元组
 * @Date 2020-11-25
 **/
public class TupleExample {

  public static void main(String[] args) {
    Tuple<Integer, Integer> point = getPoint();
    System.out.println(point);
    System.out.println(point.first);
    System.out.println(point.second);
  }

  public static Tuple<Integer, Integer> getPoint() {
    return new Tuple<>(1, 2);
  }
}
