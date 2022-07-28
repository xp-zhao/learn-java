package annotation.value;

import annotation.support.IUserInfo;
import cn.hutool.core.convert.Convert;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2022-7-20
 */
@Data
public class Employee implements IUserInfo {
  private Integer id;
  @ValidValue private Integer age;
  @ValidValue private String name;
  private String address;

  @Override
  public void setUserName(String userName) {
    this.name = userName;
  }

  @Override
  public String getUserId() {
    return Convert.toStr(id);
  }
}
