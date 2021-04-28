package com.xp.creator.factory.v2;

import com.xp.creator.factory.v2.store.ICommodity;
import com.xp.creator.factory.v2.store.impl.CardCommodityService;
import com.xp.creator.factory.v2.store.impl.CouponCommodityService;
import com.xp.creator.factory.v2.store.impl.GoodsCommodityService;

/**
 * @author zhaoxiaoping
 * @Description: 工厂类
 * @Date 2021-4-28
 **/
public class StoreFactory {

  public ICommodity getCommodityService(Integer commodityType) {
    if (null == commodityType) {
      return null;
    }
    if (1 == commodityType) {
      return new CouponCommodityService();
    }
    if (2 == commodityType) {
      return new GoodsCommodityService();
    }
    if (3 == commodityType) {
      return new CardCommodityService();
    }
    throw new RuntimeException("不存在的商品服务类型");
  }
}
