package concurrent.threadlocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * UserContent.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class UserContent implements Runnable {

  final static Map<Integer, Content> user = new ConcurrentHashMap<>();
  private final Integer userId;
  private UserRepository userRepository = new UserRepository();

  public UserContent(Integer userId) {
    this.userId = userId;
  }

  @Override
  public void run() {
    String userName = userRepository.getUserNameForUserId(userId);
    user.put(userId, new Content(userName));
  }
}