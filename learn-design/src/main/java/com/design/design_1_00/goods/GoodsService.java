package com.design.design_1_00.goods;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
 * 模拟商品服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Slf4j
public class GoodsService {
  public Boolean deliverGoods(DeliverReq req) {
    log.info("模拟发货实物商品一个： {}", JSON.toJSONString(req));
    return true;
  }
}
