package lazy;

import java.util.Set;

/** @author zhaoxiaoping @Description: Lazy 使用示例 @Date 2021-11-2 */
public class LazyExample {
  public static void main(String[] args) {
    Lazy<Integer> lazy = Lazy.of(() -> 10 + 1);
    int b = lazy.get() + 1;
    // get 不会再重新计算, 会使用缓存的值
    int c = lazy.get() + 1;
    System.out.println(b);
    System.out.println(c);
    UserFactory userFactory = new UserFactory();
    User user = userFactory.buildUser("xp");
//    String department = user.getDepartment();
    Set<String> permission = user.getPermission();
  }
}
