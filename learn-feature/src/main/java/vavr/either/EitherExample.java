package vavr.either;

import io.vavr.collection.Seq;
import io.vavr.control.Either;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import one.util.streamex.StreamEx;

/**
 * Either 类使用示例
 *
 * @author zhaoxiaoping
 * @date 2022-12-12
 */
public class EitherExample {
  public static void main(String[] args) {
    List<Either<Exception, User>> list =
        StreamEx.iterate(1, i -> i + 1).map(i -> convert(i)).limit(10).toList();
    Either<Seq<Exception>, Seq<User>> either = Either.sequence(list);
    System.out.println(either.swap());
  }

  public static Either<Exception, User> convert(Integer i) {
    if (i > 10) {
      return Either.left(new Exception("第 " + i + " 行数据错误"));
    } else {
      return Either.right(new User("success", 20));
    }
  }

  @Data
  @AllArgsConstructor
  static class User {
    private String name;
    private Integer age;
  }
}
