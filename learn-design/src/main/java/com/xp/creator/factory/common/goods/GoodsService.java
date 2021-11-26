package com.xp.creator.factory.common.goods;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: 实物商品服务
 * @Date 2021-4-28
 **/
@Slf4j
public class GoodsService {

  public Boolean deliverGoods(DeliverReq req) {
    log.info("模拟发货实物商品一个：" + JSON.toJSONString(req));
    return true;
  }
}
