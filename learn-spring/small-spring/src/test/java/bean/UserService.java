package bean;

/** @Author: xp-zhao @Description: TODO @DateTime: 2021/7/7 11:19 下午 */
public class UserService {

  private String id;
  private String uId;
  private String company;
  private String location;

  private UserDao userDao;

  public void queryUserInfo() {
    System.out.println(userDao.queryUserName(uId) + "," + company + "," + location);
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
}
