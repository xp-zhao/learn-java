package code.v7.impl;

import code.v7.AbstractCheck;
import code.v7.AccountDetail;
import code.v7.CheckEnum;
import java.io.IOException;

/**
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
public class AccountCheck extends AbstractCheck<AccountDetail> {
  @Override
  protected AccountDetail convert(String line) {
    return AccountDetail.convert(line);
  }

  @Override
  public void check(String filePathA, String filePathB) throws IOException {
    checkData(filePathA, filePathB);
  }

  @Override
  public CheckEnum getCheckEnum() {
    return CheckEnum.ACCOUNT;
  }
}
