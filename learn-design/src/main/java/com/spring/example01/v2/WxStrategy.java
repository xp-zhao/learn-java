package com.spring.example01.v2;

import com.spring.example01.RequestParam;
import org.springframework.stereotype.Component;

/**
 * wx 策略
 *
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Component
public class WxStrategy implements IStrategy {
  @Override
  public boolean match(String code) {
    return "WX".equals(code);
  }

  @Override
  public RequestParam buildParam(String accountId) {
    RequestParam param = new RequestParam();
    param.setBusinessCode("WX_" + accountId);
    param.setBusinessType(2);
    return param;
  }
}
