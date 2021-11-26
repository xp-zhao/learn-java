package com.design.design_1_00.card;

import lombok.extern.slf4j.Slf4j;

/**
 * 模拟爱奇艺会员卡服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Slf4j
public class IQiYiCardService {
  public void grantToken(String bindMobileNumber, String cardId) {
    log.info("模拟发放爱奇艺会员卡一张： {}, {}", bindMobileNumber, cardId);
  }
}
