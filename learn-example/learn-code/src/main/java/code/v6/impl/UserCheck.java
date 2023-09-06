package code.v6.impl;

import code.v6.AbstractCheck;
import code.v6.UserDetail;

/**
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
public class UserCheck extends AbstractCheck<UserDetail> {
  @Override
  protected UserDetail convert(String line) {
    return UserDetail.convert(line);
  }
}
