package proxy;

/**
 * @author zhaoxiaoping
 * @date 2022-2-17
 */
public class UserService implements IUserService {

  @Override
  public String queryUserNameById(String userId) {
    return "hi user " + userId;
  }
}
