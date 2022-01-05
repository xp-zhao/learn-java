package bean;

import org.smallspring.beans.factory.DisposableBean;
import org.smallspring.beans.factory.InitializingBean;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:19 下午 */
public class UserService implements InitializingBean, DisposableBean {

  private String id;
  private String uId;
  private String company;
  private String location;

  private UserDao userDao;

  public String queryUserInfo() {
    return userDao.queryUserName(uId) + "," + company + "," + location;
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

  public String getuId() {
    return uId;
  }

  public void setuId(String uId) {
    this.uId = uId;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("执行：UserService.destroy");
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    System.out.println("执行：UserService.afterPropertiesSet");
  }
}
