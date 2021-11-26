package com.design.design_1_02;

import com.design.design_1_02.store.ICommodity;
import com.design.design_1_02.store.impl.CardCommodityService;
import com.design.design_1_02.store.impl.CouponCommodityService;
import com.design.design_1_02.store.impl.GoodsCommodityService;

/**
 * 商店工厂
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
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
