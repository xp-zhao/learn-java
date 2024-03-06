package com.spring.example01.v1;

import com.spring.example01.RequestParam;
import lombok.extern.slf4j.Slf4j;

/**
 * 直接使用 if else 来根据不同的编码组装对应的参数
 *
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Slf4j
public class Example {
  public static void main(String[] args) {
    RequestParam param = buildParam("Alipay", "1001");
    log.info("请求参数：{}", param);
  }

  private static RequestParam buildParam(String code, String accountId) {
    RequestParam param = new RequestParam();
    if ("Alipay".equals(code)) {
      param.setBusinessCode("ALIPAY_" + accountId + "_BUSINESS");
      param.setBusinessType(1);
    } else if ("WX".equals(code)) {
      param.setBusinessCode("WX_" + accountId);
      param.setBusinessType(2);
    } else if ("Other".equals(code)) {
      param.setBusinessCode("OTHER_" + accountId);
      param.setBusinessType(3);
    }
    return param;
  }
}
