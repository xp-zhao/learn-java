package annotation.support;

/**
 * 用户信息接口
 *
 * @author zhaoxiaoping
 * @date 2022-7-28
 */
public interface IUserInfo {
  /**
   * 设置用户名
   *
   * @param userName 用户名
   */
  void setUserName(String userName);

  /**
   * 设定年龄
   *
   * @param age 年龄
   */
  void setAge(Integer age);

  /**
   * 获取用户id
   *
   * @return {@code String}
   */
  String getUserId();
}
