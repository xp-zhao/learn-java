package concurrent.threadlocal;

import java.util.UUID;

/**
 * UserRepository.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/14
 **/
public class UserRepository {

  String getUserNameForUserId(Integer userId) {
    return UUID.randomUUID().toString();
  }
}