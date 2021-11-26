package com.design.design_1_01;

import com.alibaba.fastjson.JSON;
import com.design.design_1_00.card.IQiYiCardService;
import com.design.design_1_00.coupon.CouponResult;
import com.design.design_1_00.coupon.CouponService;
import com.design.design_1_00.goods.DeliverReq;
import com.design.design_1_00.goods.GoodsService;
import lombok.extern.slf4j.Slf4j;

/**
 * 模拟发奖服务
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Slf4j
public class PrizeController {
  public AwardRes awardToUser(AwardReq req) {
    String reqJson = JSON.toJSONString(req);
    AwardRes awardRes = null;
    try {
      log.info("奖品发放开始{}。req:{}", req.getUId(), reqJson);
      // 按照不同类型方法商品[1优惠券、2实物商品、3第三方兑换卡(爱奇艺)]
      if (req.getAwardType() == 1) {
        CouponService couponService = new CouponService();
        CouponResult couponResult =
            couponService.sendCoupon(req.getUId(), req.getAwardNumber(), req.getBizId());
        if ("0000".equals(couponResult.getCode())) {
          awardRes = new AwardRes("0000", "发放成功");
        } else {
          awardRes = new AwardRes("0001", couponResult.getInfo());
        }
      } else if (req.getAwardType() == 2) {
        GoodsService goodsService = new GoodsService();
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserName(req.getUId()));
        deliverReq.setUserPhone(queryUserPhoneNumber(req.getUId()));
        deliverReq.setSku(req.getAwardNumber());
        deliverReq.setOrderId(req.getBizId());
        deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
        Boolean isSuccess = goodsService.deliverGoods(deliverReq);
        if (isSuccess) {
          awardRes = new AwardRes("0000", "发放成功");
        } else {
          awardRes = new AwardRes("0001", "发放失败");
        }
      } else if (req.getAwardType() == 3) {
        String bindMobileNumber = queryUserPhoneNumber(req.getUId());
        IQiYiCardService iQiYiCardService = new IQiYiCardService();
        iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
        awardRes = new AwardRes("0000", "发放成功");
      }
      log.info("奖品发放完成{}。", req.getUId());
    } catch (Exception e) {
      log.error("奖品发放失败{}。req:{}", req.getUId(), reqJson, e);
      awardRes = new AwardRes("0001", e.getMessage());
    }

    return awardRes;
  }

  private String queryUserName(String uId) {
    return "花花";
  }

  private String queryUserPhoneNumber(String uId) {
    return "15200101232";
  }
}
