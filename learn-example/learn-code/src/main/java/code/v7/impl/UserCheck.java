package code.v7.impl;

import code.v7.AbstractCheck;
import code.v7.CheckEnum;
import code.v7.UserDetail;
import java.io.IOException;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
@Service
public class UserCheck extends AbstractCheck<UserDetail> {
  @Override
  protected UserDetail convert(String line) {
    return UserDetail.convert(line);
  }

  @Override
  public void check(String filePathA, String filePathB) throws IOException {
    checkData(filePathA, filePathB);
  }

  @Override
  public CheckEnum getCheckEnum() {
    return CheckEnum.USER;
  }
}
