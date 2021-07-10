package bean;

/**
 * @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:19 下午
 */
public class UserService {

  private String name;

  public UserService(String name) {
    this.name = name;
  }

  public void queryUserInfo() {
    System.out.println("查询用户信息");
  }
}
