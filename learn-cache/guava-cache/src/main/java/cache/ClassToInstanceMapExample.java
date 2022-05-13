package cache;

import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.MutableClassToInstanceMap;
import entity.Dept;
import entity.User;

/**
 * 实例 Map 使用示例
 *
 * @author zhaoxiaoping
 * @date 2022-5-13
 */
public class ClassToInstanceMapExample {
  public static void main(String[] args) {
    ClassToInstanceMap<Object> instanceMap = MutableClassToInstanceMap.create();
    User user = new User("Hydra", 18);
    Dept dept = new Dept("develop", 200);

    instanceMap.putInstance(User.class, user);
    instanceMap.putInstance(Dept.class, dept);
    User user1 = instanceMap.getInstance(User.class);
    System.out.println(user == user1);
  }
}
