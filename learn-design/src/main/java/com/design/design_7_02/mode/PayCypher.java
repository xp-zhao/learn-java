package com.design.design_7_02.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * 密码支付
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Slf4j
public class PayCypher implements IPayMode {

  @Override
  public boolean security(String uId) {
    log.info("密码支付，风控校验环境安全");
    return true;
  }
}
