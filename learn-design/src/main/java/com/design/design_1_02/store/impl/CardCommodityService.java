package com.design.design_1_02.store.impl;

import com.alibaba.fastjson.JSON;
import com.design.design_1_00.card.IQiYiCardService;
import com.design.design_1_02.store.ICommodity;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 会员卡奖品发放服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Slf4j
public class CardCommodityService implements ICommodity {

  /** 模拟注入 */
  private IQiYiCardService iQiYiCardService = new IQiYiCardService();

  @Override
  public void sendCommodity(
      String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception {
    String mobile = queryUserMobile(uId);
    iQiYiCardService.grantToken(mobile, bizId);
    log.info(
        "请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}",
        uId,
        commodityId,
        bizId,
        JSON.toJSON(extMap));
    log.info("测试结果[爱奇艺兑换卡]：success");
  }

  private String queryUserMobile(String uId) {
    return "15200101232";
  }
}
