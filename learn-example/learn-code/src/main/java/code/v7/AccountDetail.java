package code.v7;

import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
@Data
public class AccountDetail implements IKey {
  private String uuid;
  private Integer balance;

  public static AccountDetail convert(String line) {
    AccountDetail detail = new AccountDetail();
    String[] split = line.split(",");
    detail.setUuid(split[0]);
    return detail;
  }

  @Override
  public String getKey() {
    return uuid + balance;
  }
}
