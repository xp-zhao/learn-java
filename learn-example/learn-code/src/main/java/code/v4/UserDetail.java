package code.v4;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
@Data
public class UserDetail {
  private String uuid;
  private Integer age;
  private String gender;
  private String address;

  public static UserDetail convert(String line) {
    UserDetail detail = new UserDetail();
    String[] split = line.split(",");
    detail.setUuid(split[0]);
    return detail;
  }
}
