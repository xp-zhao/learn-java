package bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2021-7-14
 **/
public class UserDao {

  private static Map<String, String> hashMap = new HashMap<>();

  static {
    hashMap.put("10001", "10001");
    hashMap.put("10002", "10002");
    hashMap.put("10003", "10003");
  }

  public String queryUserName(String id) {
    return hashMap.get(id);
  }
}
