package streamex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import one.util.streamex.StreamEx;
import org.junit.Before;
import org.junit.Test;
import streamex.User.Role;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2022-8-15
 */
public class StreamExTest {

  private List<User> users = new ArrayList<>();

  @Before
  public void init() {
    User user1 = new User();
    user1.setId(1);
    user1.setName("111");
    user1.setRole(new Role());
    User user2 = new User();
    user2.setId(2);
    user2.setName("222");
    user2.setRole(new Role());
    users.add(user1);
    users.add(user2);
  }

  @Test
  public void testMap() {
    List<String> nameList = StreamEx.of(users).map(User::getName).toList();
    System.out.println(nameList);
  }

  @Test
  public void testGroupBy() {
    Map<Integer, List<User>> userMap = StreamEx.of(users).groupingBy(User::getId);
    System.out.println(userMap);
  }

  @Test
  public void testJoin() {
    System.out.println(StreamEx.of(1, 2, 3).joining(":"));
  }

  @Test
  public void testPrepend() {
    List<String> list =
        StreamEx.of(users).map(User::getName).prepend("prepend").append("Last").toList();
    System.out.println(list);
  }
}
