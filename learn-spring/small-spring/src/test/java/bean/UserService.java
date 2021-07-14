package bean;

import cn.hutool.core.util.StrUtil;

/**
 * @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:19 下午
 */
public class UserService {

  private String id;
  private UserDao userDao;

  public void queryUserInfo() {
    System.out.println(StrUtil.format("查询用户信息: {}", userDao.queryUserName(id)));
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
