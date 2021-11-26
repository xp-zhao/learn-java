package com.xp.struct.bridge.v2.mode;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 人脸支付
 * @Date 2021-4-30
 **/
@Slf4j
public class PayFaceMode implements IPayMode {

  @Override
  public boolean security(String uId) {
    log.info("人脸支付，风控校验脸部识别");
    return false;
  }
}
