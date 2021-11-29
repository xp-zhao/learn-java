package com.design.design_7_02.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * 人脸识别支付
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Slf4j
public class PayFaceMode implements IPayMode {

  @Override
  public boolean security(String uId) {
    log.info("人脸支付，风控校验脸部识别");
    return true;
  }
}
