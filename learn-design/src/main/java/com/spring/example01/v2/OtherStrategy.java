package com.spring.example01.v2;

import com.spring.example01.RequestParam;
import org.springframework.stereotype.Component;

/**
 * Other 策略
 *
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Component
public class OtherStrategy implements IStrategy {
  @Override
  public boolean match(String code) {
    return "Other".equals(code);
  }

  @Override
  public RequestParam buildParam(String accountId) {
    RequestParam param = new RequestParam();
    param.setBusinessCode("OTHER_" + accountId);
    param.setBusinessType(3);
    return param;
  }
}
