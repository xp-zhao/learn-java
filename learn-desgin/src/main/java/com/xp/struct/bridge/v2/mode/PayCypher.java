package com.xp.struct.bridge.v2.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 密码支付
 * @Date 2021-4-30
 **/
@Slf4j
public class PayCypher implements IPayMode {

  @Override
  public boolean security(String uId) {
    log.info("密码支付，风控校验环境安全");
    return false;
  }
}
