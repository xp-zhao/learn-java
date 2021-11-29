package com.design.design_7_02.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * 指纹支付
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Slf4j
public class PayFingerprintMode implements IPayMode {

  @Override
  public boolean security(String uId) {
    log.info("指纹支付，风控校验指纹信息");
    return true;
  }
}
