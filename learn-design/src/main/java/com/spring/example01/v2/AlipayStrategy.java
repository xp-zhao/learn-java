package com.spring.example01.v2;

import com.spring.example01.RequestParam;
import org.springframework.stereotype.Component;

/**
 * Alipay 策略
 *
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Component
public class AlipayStrategy implements IStrategy {
  @Override
  public boolean match(String code) {
    return "Alipay".equals(code);
  }

  @Override
  public RequestParam buildParam(String accountId) {
    RequestParam param = new RequestParam();
    param.setBusinessCode("ALIPAY_" + accountId + "_BUSINESS");
    param.setBusinessType(1);
    return param;
  }
}
