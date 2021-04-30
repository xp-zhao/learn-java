package com.xp.struct.bridge.v2.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 指纹支付
 * @Date 2021-4-30
 **/
@Slf4j
public class PayFingerprintMode implements IPayMode {

  @Override
  public boolean security(String uId) {
    log.info("指纹支付，风控校验指纹信息");
    return false;
  }
}
