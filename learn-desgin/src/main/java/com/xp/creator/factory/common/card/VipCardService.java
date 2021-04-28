package com.xp.creator.factory.common.card;


import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 会员卡服务
 * @Date 2021-4-28
 **/
@Slf4j
public class VipCardService {

  public void sendCard(String bindMobileNumber, String cardId) {
    log.info("模拟发放会员卡一张: {}, {}", bindMobileNumber, cardId);
  }
}
