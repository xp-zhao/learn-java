package code.v6.impl;

import code.v6.AbstractCheck;
import code.v6.AccountDetail;

/**
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
public class AccountCheck extends AbstractCheck<AccountDetail> {
  @Override
  protected AccountDetail convert(String line) {
    return AccountDetail.convert(line);
  }
}
