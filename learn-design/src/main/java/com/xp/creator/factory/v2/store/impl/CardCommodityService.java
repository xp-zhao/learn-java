package com.xp.creator.factory.v2.store.impl;

import com.alibaba.fastjson.JSON;
import com.xp.creator.factory.common.card.VipCardService;
import com.xp.creator.factory.v2.store.ICommodity;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 会员卡服务
 * @Date 2021-4-28
 **/
@Slf4j
public class CardCommodityService implements ICommodity {

  private VipCardService vipCardService = new VipCardService();

  @Override
  public void sendCommodity(String uId, String commodityId, String bizId,
      Map<String, String> extMap) throws Exception {
    String mobile = queryUserMobile(uId);
    vipCardService.sendCard(mobile, bizId);
    log.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId,
        JSON
            .toJSON(extMap));
    log.info("测试结果[爱奇艺兑换卡]：success");
  }

  private String queryUserMobile(String uId) {
    return "15200101232";
  }
}
