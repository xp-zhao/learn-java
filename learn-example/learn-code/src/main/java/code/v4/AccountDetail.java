package code.v4;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
@Data
public class AccountDetail {
  private String uuid;
  private Integer balance;

  public static AccountDetail convert(String line) {
    AccountDetail detail = new AccountDetail();
    String[] split = line.split(",");
    detail.setUuid(split[0]);
    return detail;
  }
}
